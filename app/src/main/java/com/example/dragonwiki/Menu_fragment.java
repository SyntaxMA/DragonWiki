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

        close = view.findViewById(R.id.closecapsula);
        visible = view.findViewById(R.id.fotocapsula);
        fondoverde = view.findViewById(R.id.fondocapsula);
        cartas = view.findViewById(R.id.Buttoncartas);
        online = view.findViewById(R.id.Buttononline);


        fondoverde.setVisibility(View.INVISIBLE);
        close.setVisibility(View.INVISIBLE);


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
    }
}