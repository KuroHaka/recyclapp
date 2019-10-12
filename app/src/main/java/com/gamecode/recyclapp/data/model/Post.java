package com.gamecode.recyclapp.data.model;

import java.util.HashMap;

public class Post {

    private String title;
    private String image;
    private String username;
    private String usernameImg;

    public Post(HashMap<String, String> map) {
        this.title = map.get("title");
        this.image = map.get("image");
        this.username = map.get("username");
        this.usernameImg = map.get("usernameImg");
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
}
