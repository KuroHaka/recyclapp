package com.gamecode.recyclapp.ui.home;

import android.content.Intent;
import android.os.Bundle;

import com.gamecode.recyclapp.PostViwer;
import com.gamecode.recyclapp.data.model.Post;
import com.gamecode.recyclapp.ui.NewPost;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import com.gamecode.recyclapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomePage extends AppCompatActivity {

    RecyclerView recyclerView;
    PostAdapter mAdapter;
    private DatabaseReference mDatabase;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        username = i.getStringExtra("Mail");
        username = getStringFromMail(username);
        recyclerView = findViewById(R.id.reciclerView);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new PostAdapter();
        mAdapter.setListener(new PostAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Post post) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("post",post);
                Intent intent = new Intent(HomePage.this, PostViwer.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(HomePage.this, NewPost.class);
                intent.putExtra("username",username);
                startActivity(intent);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        fetchPosts();
    }

    private DatabaseReference mPostReference;

    private void fetchPosts() {
        mPostReference = mDatabase.getRef().child("Posts");
        mPostReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<HashMap<String, String>> posts = (List<HashMap<String, String>>) dataSnapshot.getValue();

                List<Post> postList = new ArrayList<>();
                for (int i = 0; i < posts.size(); i++) {
                    Post post = new Post(posts.get(i));
                    postList.add(post);
                }

                mAdapter.setDataSet(postList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("", "loadPost:onCancelled", databaseError.toException());
            }
        });
    }


    public String getStringFromMail(String mail) {
        String[] userNickParts = mail.split("@");
        if (userNickParts.length > 0)
            return userNickParts[0];
        else
            return null;
    }
}
