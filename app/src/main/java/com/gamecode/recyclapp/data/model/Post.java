package com.gamecode.recyclapp.data.model;

import android.view.ContextThemeWrapper;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gamecode.recyclapp.ui.home.HomePage;

import java.util.HashMap;

public class Post {

    private String title;
    private String image;
    private String username;
    private String usernameImg;
    private String tag;

    public Post(HashMap<String, String> map) {
        this.image = map.get("image");
        this.username = map.get("username");
        this.usernameImg = map.get("usernameImg");
        this.title = map.get("title");
        this.tag = map.get("tag");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameImg() {
        return usernameImg;
    }

    public void setUsernameImg(String usernameImg) {
        this.usernameImg = usernameImg;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
