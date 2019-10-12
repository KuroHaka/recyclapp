package com.gamecode.recyclapp.data.model;

import java.util.HashMap;

public class Post {

    private String title;
    private String image;

    public Post(HashMap<String, String> map) {
        this.title = map.get("title");
        this.image = map.get("image");
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
}
