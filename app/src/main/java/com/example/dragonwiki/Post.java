package com.example.dragonwiki;

import java.util.HashMap;
import java.util.Map;

public class Post {
    public String id;
    public String uid;
    public String author;
    public String authorPhotoUrl;
    public String content;
    public String mediaUrl;
    public String mediaType;
    public Map<String, Boolean> likes = new HashMap<>();
    public long date;

    // Constructor vacio requerido por Firestore
    public Post() {}
    public Post(String uid, String author, String authorPhotoUrl, String content, String mediaUrl, String mediaType, long date) {
        this.uid = uid;
        this.author = author;
        this.authorPhotoUrl = authorPhotoUrl;
        this.content = content;
        this.mediaUrl = mediaUrl;
        this.mediaType = mediaType;
        this.date = date;
    }
}