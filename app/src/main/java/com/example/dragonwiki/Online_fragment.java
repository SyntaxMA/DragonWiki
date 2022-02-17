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

    ImageView noticias;
    Button cierranotis;

    ImageView inicio;
    View notifrag;

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
            }
        });

        cierranotis = view.findViewById(R.id.notisclose);
        cierranotis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifrag.setVisibility(View.INVISIBLE);
            }
        });

    }

}