package com.gamecode.recyclapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gamecode.recyclapp.data.model.Post;

public class PostViwer extends AppCompatActivity {
    ImageView postImage;
    ImageView profilePhoto;
    TextView description;
    TextView username;
    TextView title;
    ImageButton notstar;
    ImageButton star;
    Post post;
    boolean starOn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_viwer);
        Intent intent = this.getIntent();
        postImage = findViewById(R.id.articleImage);
        starOn = false;
        profilePhoto = findViewById(R.id.profileImg);
        description = findViewById(R.id.description);
        username = findViewById(R.id.usernameStr);
        title = findViewById(R.id.articleTitle);
        notstar = findViewById(R.id.starOff);
        star = findViewById(R.id.starOn);

        star.setVisibility(View.INVISIBLE);
        notstar.setVisibility(View.VISIBLE);

        Bundle bundle = intent.getExtras();
        post = (Post) bundle.getSerializable("post");

        Glide.with(getApplicationContext())
                .load(post.getImage())
                .centerCrop()
                .into(postImage);

        Glide.with(getApplicationContext())
                .load(post.getUsernameImg())
                .centerCrop()
                .apply(RequestOptions.circleCropTransform())
                .into(profilePhoto);

        description.setText(post.getDescription());
        username.setText(post.getUsername());
        title.setText(post.getTitle());

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star.setVisibility(View.INVISIBLE);
                notstar.setVisibility(View.VISIBLE);
            }
        });

        notstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star.setVisibility(View.VISIBLE);
                notstar.setVisibility(View.INVISIBLE);
            }
        });
    }
}
