package com.example.dragonwiki;

public class Card {
    public String id;
    public String content;
    public String attack;
    public String deffence;
    public String vida;
    public String mediaUrl;
    public String mediaCompleto;
    public String mediaType;

    // Constructor vacio requerido por Firestore
    public Card() {}
    public Card(String content, String attack, String deffence, String vida,String mediaUrl,String mediaCompleto ,String mediaType) {

        this.content = content;
        this.attack = attack;
        this.deffence = deffence;
        this.vida = vida;
        this.mediaUrl = mediaUrl;
        this.mediaCompleto = mediaCompleto;
        this.mediaType = mediaType;
    }
}
