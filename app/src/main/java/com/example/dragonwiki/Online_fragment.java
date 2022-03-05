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
import android.widget.ScrollView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Online_fragment extends Fragment {

    NavController navController;

    /* DIVIDIDOS EN SUS BOTONES RESPECTIVOS */

    // LOS DE PERSONAJES
    ImageView personajes;

    // LOS DE MAZOS
    ImageView mazos;

    // LOS DE  INICIO
    ImageView inicio;

    // LOS DE GUIA
    ImageView guias;

    FloatingActionButton crear;
    Button publica;
    Button vuelta;

    View form;
    ScrollView scroll;

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
        return inflater.inflate(R.layout.fragment_online, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        form = view.findViewById(R.id.formulario);
        scroll = view.findViewById(R.id.scrollView2);
        publica = view.findViewById(R.id.buttonpublicar);
        vuelta = view.findViewById(R.id.buttonvuelta);

        /* IR AL MENU PERSONAJES */

        personajes = view.findViewById(R.id.radar1);
        personajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_online_fragment_to_personajes_fragment);
            }
        });

        /* MOSTRAR Y OCULTAR LAS NOTICIAS */

        mazos = view.findViewById(R.id.radar2);
        mazos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_online_fragment_to_cartas_fragment);
            }
        });

        /* IR AL MENU PRINCIPAL */

        inicio = view.findViewById(R.id.radar3);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_online_fragment_to_menu_fragment);
            }
        });

        /* IR AL MENU GUIAS */

        guias = view.findViewById(R.id.radar5);
        guias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_online_fragment_to_guias_fragment);
            }
        });

        crear = view.findViewById(R.id.botoncrear);
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                form.setVisibility(View.VISIBLE);
                scroll.setVisibility(View.INVISIBLE);
                crear.setVisibility(View.INVISIBLE);
            }
        });

        vuelta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                form.setVisibility(View.INVISIBLE);
                scroll.setVisibility(View.VISIBLE);
                crear.setVisibility(View.VISIBLE);
            }
        });

        publica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                form.setVisibility(View.INVISIBLE);
                scroll.setVisibility(View.VISIBLE);
                crear.setVisibility(View.VISIBLE);
            }
        });
    }
}