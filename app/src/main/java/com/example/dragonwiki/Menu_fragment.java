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


public class Menu_fragment extends Fragment {

    NavController navController;

    Button enlace;

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

    /* COSAS DE LA CAPSULA DEL MENU */

    ImageView visible;
    ImageView fondoverde;

    Button close;
    Button cartas;
    Button online;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        /* COSAS DE LA CAPSULA DEL MENU */

        visible = view.findViewById(R.id.fotocapsula);
        cartas = view.findViewById(R.id.Buttoncartas);
        online = view.findViewById(R.id.Buttononline);

        fondoverde = view.findViewById(R.id.fondocapsula);
        close = view.findViewById(R.id.closecapsula);

        fondoverde.setVisibility(View.INVISIBLE);
        close.setVisibility(View.INVISIBLE);

        notifrag = view.findViewById(R.id.fragment_noticias);
        summonfrag = view.findViewById(R.id.fragment_summons);


        visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* HACER VISIBLE LOS BOTONES */
                fondoverde.setVisibility(View.VISIBLE);
                close.setVisibility(View.VISIBLE);
                cartas.setVisibility(View.VISIBLE);
                online.setVisibility(View.VISIBLE);

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* HACER INVISIBLE LOS BOTONES */
                fondoverde.setVisibility(View.INVISIBLE);
                close.setVisibility(View.INVISIBLE);
                cartas.setVisibility(View.INVISIBLE);
                online.setVisibility(View.INVISIBLE);
            }
        });

        enlace = view.findViewById(R.id.Buttoncartas);
        enlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_menu_fragment_to_cartas_fragment);
            }
        });

        enlace = view.findViewById(R.id.Buttononline);
        enlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_menu_fragment_to_online_fragment);
            }
        });

        /* OCULTAR LOS OVERLAYS */

        inicio = view.findViewById(R.id.radar3);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifrag.setVisibility(View.INVISIBLE);
                summonfrag.setVisibility(View.INVISIBLE);

                visible.setVisibility(View.VISIBLE);

            }
        });



        /* MOSTRAR Y OCULTAR LAS NOTICIAS */

        noticias = view.findViewById(R.id.radar2);
        noticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifrag.setVisibility(View.VISIBLE);
                summonfrag.setVisibility(View.INVISIBLE);

                fondoverde.setVisibility(View.INVISIBLE);
                close.setVisibility(View.INVISIBLE);
                cartas.setVisibility(View.INVISIBLE);
                online.setVisibility(View.INVISIBLE);
                visible.setVisibility(View.INVISIBLE);
            }
        });

        cierranotis = view.findViewById(R.id.notisclose);
        cierranotis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifrag.setVisibility(View.INVISIBLE);
                visible.setVisibility(View.VISIBLE);

            }
        });

        /* MOSTRAR Y OCULTAR EL SUMMONS */

        summons = view.findViewById(R.id.radar4);
        summons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                summonfrag.setVisibility(View.VISIBLE);
                notifrag.setVisibility(View.INVISIBLE);

                fondoverde.setVisibility(View.INVISIBLE);
                close.setVisibility(View.INVISIBLE);
                cartas.setVisibility(View.INVISIBLE);
                online.setVisibility(View.INVISIBLE);
                visible.setVisibility(View.INVISIBLE);
            }
        });

        cierrasummons = view.findViewById(R.id.summonsclose);
        cierrasummons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                summonfrag.setVisibility(View.INVISIBLE);
                visible.setVisibility(View.VISIBLE);

            }
        });
    }
}