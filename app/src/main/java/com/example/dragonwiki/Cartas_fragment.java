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

public class Cartas_fragment extends Fragment {

    NavController navController;

    /* DIVIDIDOS EN SUS BOTONES RESPECTIVOS */

    // LOS DE PERSONAJES
    ImageView personajes;

    // LOS DE  INICIO
    ImageView inicio;

    // LOS DE ONLINE
    ImageView online;

    // LOS DE GUIA
    ImageView guias;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mazos, container, false);
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
                navController.navigate(R.id.action_cartas_fragment_to_personajes_fragment);
            }
        });

        /* IR AL MENU PRINCIPAL */

        inicio = view.findViewById(R.id.radar3);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_cartas_fragment_to_menu_fragment);
            }
        });

        /* MOSTRAR Y OCULTAR EL SUMMONS */

        online = view.findViewById(R.id.radar4);
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_cartas_fragment_to_online_fragment);
            }
        });

        /* IR AL MENU GUIAS */

        guias = view.findViewById(R.id.radar5);
        guias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_cartas_fragment_to_guias_fragment);
            }
        });

    }
}