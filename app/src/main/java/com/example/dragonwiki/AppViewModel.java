package com.example.dragonwiki;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class AppViewModel extends AndroidViewModel {
    public static class Media {
        public Uri uri;
        public String tipo;

        public Media(Uri uri, String tipo) {
            this.uri = uri;
            this.tipo = tipo;
        }
    }
    public static class Mediacard {
        public Uri uri;
        public Uri uricompleto;
        public String tipo;

        public Mediacard(Uri uri, Uri uricompleto, String tipo) {
            this.uri = uri;
            this.uricompleto = uricompleto;
            this.tipo = tipo;
        }
    }
    public MutableLiveData<Post> postSeleccionado = new MutableLiveData<>();
    public MutableLiveData<Card> cardSeleccionado = new MutableLiveData<>();
    public MutableLiveData<Media> mediaSeleccionado = new MutableLiveData<>();
    public MutableLiveData<Mediacard> mediacardSeleccionado = new MutableLiveData<>();

    public AppViewModel(@NonNull Application application) {
        super(application);
    }
    public void setMediaSeleccionado(Uri uri, String type) {
        mediaSeleccionado.setValue(new Media(uri, type));
    }
    public void setMediacardSeleccionado(Uri uri, Uri uricompleto, String type) {
        mediacardSeleccionado.setValue(new Mediacard(uri, uricompleto , type));
    }
}
