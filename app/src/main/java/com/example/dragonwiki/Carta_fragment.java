package com.example.dragonwiki;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Carta_fragment extends Fragment {
    ImageView imageView;
    TextView nombreView;
    TextView ataqueView;
    TextView defensaView;
    TextView vidaView;

    String id_document;
    Button atrasimagen;

    NavController navController;
    FirebaseFirestore db;
    public AppViewModel appViewModel;
    public Carta_fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carta, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        appViewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);

        imageView = view.findViewById(R.id.imageCarta);
        nombreView = view.findViewById(R.id.cardName);
        ataqueView = view.findViewById(R.id.numeroataque);
        defensaView = view.findViewById(R.id.numerodefensa);
        vidaView = view.findViewById(R.id.numerovida);

        atrasimagen = view.findViewById(R.id.atrascarta);
        atrasimagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.personajes_fragment);
            }
        });
        db = FirebaseFirestore.getInstance();
        final DocumentReference docRef = db.collection("cards").document("ArdhjCQMLYjDNHNj1bhO");
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e);
                    return;
                }

                if (snapshot != null && snapshot.exists()) {
                    nombreView.setText(snapshot.getData().get("content").toString());
                    ataqueView.setText(snapshot.getData().get("attack").toString());
                    defensaView.setText(snapshot.getData().get("deffence").toString());
                    vidaView.setText(snapshot.getData().get("vida").toString());

                } else {
                    Log.d(TAG, "Current data: null");
                }
            }
        });
        appViewModel.cardSeleccionado.observe(getViewLifecycleOwner(), card ->
        {
            Glide.with(requireView()).load(card.mediaCompleto).into(imageView);
        });
    }
}