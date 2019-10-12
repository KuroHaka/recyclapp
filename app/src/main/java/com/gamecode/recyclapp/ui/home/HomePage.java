package com.gamecode.recyclapp.ui.home;

import android.content.Intent;
import android.os.Bundle;

import com.gamecode.recyclapp.data.model.Post;
import com.gamecode.recyclapp.ui.NewPost;
import com.gamecode.recyclapp.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.util.Map;

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
        //username
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
        recyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, NewPost.class);
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

    private void storePost(Post post) {


    }

    public String getStringFromMail(String mail) {
        String substr = "";
        char[] arrayMail = mail.toCharArray();
        for (int i = 0; i < mail.length(); i++)
        {
            if (arrayMail[i] != '@')
                substr += arrayMail[i];
            else
                break;
        }
        return substr;
    }
}
