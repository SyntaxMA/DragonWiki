package com.example.dragonwiki;

import android.database.Observable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.concurrent.TimeUnit;

public class Personajes_fragment extends Fragment {

    NavController navController;

    /* DIVIDIDOS EN SUS BOTONES RESPECTIVOS */

    // LOS DE MAZOS
    ImageView mazos;

    // LOS DE  INICIO
    ImageView inicio;

    // LOS DE ONLINE
    ImageView online;

    // LOS DE GUIA
    ImageView guias;

    ProgressBar progressBar;

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

        /* MOSTRAR Y OCULTAR LAS NOTICIAS */

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

        /* MOSTRAR Y OCULTAR EL SUMMONS */

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

        progressBar = view.findViewById(R.id.progressBar1);


    }
}