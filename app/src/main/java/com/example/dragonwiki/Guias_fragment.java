package com.example.dragonwiki;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Guias_fragment extends Fragment {

    NavController navController;

    /* DIVIDIDOS EN SUS BOTONES RESPECTIVOS */

    // LOS DE PERSONAJES
    ImageView personajes;

    // LOS DE MAZOS
    ImageView mazos;

    // LOS DE  INICIO
    ImageView inicio;

    // LOS DE ONLINE
    ImageView online;

    // BABA LEVITANDO
    ImageView babafoto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_guias, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        /* IR AL MENU PERSONAJES */

        personajes = view.findViewById(R.id.radar1);
        personajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_guias_fragment_to_personajes_fragment);
            }
        });

        /* MOSTRAR Y OCULTAR LAS NOTICIAS */

        mazos = view.findViewById(R.id.radar2);
        mazos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_guias_fragment_to_cartas_fragment);
            }
        });
        /* IR AL MENU PRINCIPAL */

        inicio = view.findViewById(R.id.radar3);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_guias_fragment_to_menu_fragment);
            }
        });

        /* MOSTRAR Y OCULTAR EL SUMMONS */

        online = view.findViewById(R.id.radar4);
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_guias_fragment_to_online_fragment);
            }
        });
    }
}