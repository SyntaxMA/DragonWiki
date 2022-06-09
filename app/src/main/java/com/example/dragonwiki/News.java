package com.example.dragonwiki;

public class News {
    public String id;
    public String mediaUrl;

    // Constructor vacio requerido por Firestore
    public News() {}
    public News(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
}
