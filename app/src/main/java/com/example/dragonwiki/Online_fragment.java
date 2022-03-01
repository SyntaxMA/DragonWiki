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


public class Online_fragment extends Fragment {

    NavController navController;
    ImageView inicio;

    /* LOS FRAGMENTS DEL MENU INFERIOR */
    View summonfrag;
    View notifrag;

    /* DIVIDIDOS EN SUS BOTONES RESPECTIVOS */

    // LOS DE NOTICIAS
    ImageView noticias;
    Button cierranotis;

    // LOS DE SUMMONS
    ImageView summons;
    Button cierrasummons;

    // LOS DE PERSONAJES;
    ImageView personajes;

    // LOS DE GUIAS;
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
        return inflater.inflate(R.layout.fragment_online, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        notifrag = view.findViewById(R.id.fragment_noticias);
        summonfrag = view.findViewById(R.id.fragment_summons);

        /* IR AL MENU PERSONAJES */

        personajes = view.findViewById(R.id.radar1);
        personajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_online_fragment_to_personajes_fragment);
            }
        });

        inicio = view.findViewById(R.id.radar3);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_online_fragment_to_menu_fragment);
            }
        });

        noticias = view.findViewById(R.id.radar2);
        noticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifrag.setVisibility(View.VISIBLE);
                summonfrag.setVisibility(View.INVISIBLE);

            }
        });

        cierranotis = view.findViewById(R.id.notisclose);
        cierranotis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifrag.setVisibility(View.INVISIBLE);
            }
        });

        /* MOSTRAR Y OCULTAR EL SUMMONS */

        summons = view.findViewById(R.id.radar4);
        summons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                summonfrag.setVisibility(View.VISIBLE);
                notifrag.setVisibility(View.INVISIBLE);

            }
        });

        cierrasummons = view.findViewById(R.id.summonsclose);
        cierrasummons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                summonfrag.setVisibility(View.INVISIBLE);
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

    }

}