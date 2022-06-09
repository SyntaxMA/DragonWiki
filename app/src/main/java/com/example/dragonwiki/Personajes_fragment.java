package com.example.dragonwiki;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.Date;

public class Personajes_fragment extends Fragment {

    NavController navController;
    public AppViewModel appViewModel;

    /* DIVIDIDOS EN SUS BOTONES RESPECTIVOS */

    // LOS DE MAZOS
    ImageView mazos;

    // LOS DE  INICIO
    ImageView inicio;

    // LOS DE ONLINE
    ImageView online;

    // LOS DE GUIA
    ImageView guias;

    Button atras;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_personajes, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        atras = view.findViewById(R.id.buttonatras);


        //Declarar las cartas

        RecyclerView cardsRecyclerView = view.findViewById(R.id.cardsRecyclerView);

        Query query = FirebaseFirestore.getInstance().collection("cards");

        FirestoreRecyclerOptions<Card> options = new FirestoreRecyclerOptions.Builder<Card>()
                .setQuery(query, Card.class)
                .setLifecycleOwner(this)
                .build();

        cardsRecyclerView.setAdapter(new CardsAdapter(options));
        appViewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);

        /* IR AL MENU MAZOS */

        mazos = view.findViewById(R.id.radar2);
        mazos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_personajes_fragment_to_cartas_fragment);
            }
        });
        /* IR AL MENU PRINCIPAL */

        inicio = view.findViewById(R.id.radar3);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_personajes_fragment_to_menu_fragment);
            }
        });

        /* IR AL MENU ONLINE */

        online = view.findViewById(R.id.radar4);
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_personajes_fragment_to_online_fragment);
            }
        });

        /* IR AL MENU GUIAS */

        guias = view.findViewById(R.id.radar5);
        guias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_personajes_fragment_to_guias_fragment);
            }
        });

        view.findViewById(R.id.botoncrearcarta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.newCardFragment);
            }
        });
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atras.setVisibility(View.INVISIBLE);
            }
        });

    }

    class CardsAdapter extends FirestoreRecyclerAdapter<Card, CardsAdapter.CardViewHolder> {
        public CardsAdapter(@NonNull FirestoreRecyclerOptions<Card> options) {
            super(options);
        }

        @NonNull
        @Override
        public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CardViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_card, parent, false));
        }

        @Override
        protected void onBindViewHolder(@NonNull CardViewHolder holder, int position, @NonNull final Card card) {
            if (card.mediaUrl != null) {
                Glide.with(getContext()).load(card.mediaUrl).into(holder.authorPhotoImageView);
            } else {
                Glide.with(getContext()).load(R.drawable.iconcartas).into(holder.authorPhotoImageView);
            }
            // Miniatura de media
            if (card.mediaUrl != null) {
                holder.authorPhotoImageView.setVisibility(View.VISIBLE);
                Glide.with(requireView()).load(card.mediaUrl).centerCrop().into(holder.authorPhotoImageView);
                holder.authorPhotoImageView.setOnClickListener(view -> {
                    appViewModel.cardSeleccionado.setValue(card);
                    navController.navigate(R.id.carta_fragment);
                });
            } else {
                holder.authorPhotoImageView.setVisibility(View.GONE);

            }
        }

        class CardViewHolder extends RecyclerView.ViewHolder {
            ImageView authorPhotoImageView;

            CardViewHolder(@NonNull View itemView) {
                super(itemView);
                authorPhotoImageView = itemView.findViewById(R.id.photoImageView);
            }
        }
    }
}