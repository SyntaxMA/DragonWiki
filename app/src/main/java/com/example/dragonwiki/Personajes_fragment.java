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

    // CARTAS
    ImageView carta01;
    ImageView carta02;
    ImageView carta03;
    ImageView carta04;
    ImageView carta05;
    ImageView carta06;
    ImageView carta07;
    ImageView carta08;

    Button atras;

    View gokustr;
    View gokuagl;


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

        //Declarar las cartas

        carta03 = view.findViewById(R.id.card3);
        carta04 = view.findViewById(R.id.card4);
        carta05 = view.findViewById(R.id.card5);
        carta06 = view.findViewById(R.id.card6);
        carta07 = view.findViewById(R.id.card7);
        carta08 = view.findViewById(R.id.card8);

        atras = view.findViewById(R.id.buttonatras);

        gokustr = view.findViewById(R.id.cartagoku);
        gokuagl = view.findViewById(R.id.gokulr);

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

        carta01 = view.findViewById(R.id.card1);
        carta01.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                gokustr.setVisibility(View.VISIBLE);
                atras.setVisibility(View.VISIBLE);
                return true;
            }
        });

        carta02 = view.findViewById(R.id.card2);
        carta02.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                gokuagl.setVisibility(View.VISIBLE);
                atras.setVisibility(View.VISIBLE);
                return true;
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gokustr.setVisibility(View.INVISIBLE);
                gokuagl.setVisibility(View.INVISIBLE);
                atras.setVisibility(View.INVISIBLE);

            }
        });


    }
}