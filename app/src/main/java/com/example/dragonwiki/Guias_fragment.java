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

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

public class Guias_fragment extends Fragment {

    NavController navController;

    Button enlace;

    /* LOS FRAGMENTS DE CADA GUÍA */

    View guia1;
    Button botonguia1;
    Button cerrarguia1;

    View guia2;
    Button botonguia2;
    Button cerrarguia2;

    View guia3;
    Button botonguia3;
    Button cerrarguia3;

    View guia4;
    Button botonguia4;
    Button cerrarguia4;

    View guia5;
    Button botonguia5;
    Button cerrarguia5;

    View guia6;
    Button botonguia6;
    Button cerrarguia6;

    Button botonguia7;
    View menuinfer;

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

        /* VISIBILIDADES DE LAS GUIAS */

        botonguia1 = view.findViewById(R.id.infobasica);
        guia1 = view.findViewById(R.id.guiafrag1);
        cerrarguia1 = view.findViewById(R.id.cerrarguias1);

        botonguia2 = view.findViewById(R.id.infocartas);
        guia2 = view.findViewById(R.id.guiafrag2);
        cerrarguia2 = view.findViewById(R.id.cerrarguias2);

        botonguia3 = view.findViewById(R.id.creamazos);
        guia3 = view.findViewById(R.id.guiafrag3);
        cerrarguia3 = view.findViewById(R.id.cerrarguias3);

        botonguia4 = view.findViewById(R.id.mazosavanzado);
        guia4 = view.findViewById(R.id.guiafrag4);
        cerrarguia4 = view.findViewById(R.id.cerrarguias4);

        botonguia5 = view.findViewById(R.id.infonoticias);
        guia5 = view.findViewById(R.id.guiafrag5);
        cerrarguia5 = view.findViewById(R.id.cerrarguias5);

        botonguia6 = view.findViewById(R.id.infoonline);
        guia6 = view.findViewById(R.id.guiafrag6);
        cerrarguia6 = view.findViewById(R.id.cerrarguias6);

        botonguia7 = view.findViewById(R.id.buttoncerrar);
        botonguia7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GoogleSignIn.getClient(requireActivity(), new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.default_web_client_id))
                        .build()).signOut();

                FirebaseAuth.getInstance().signOut();

                Navigation.findNavController(view).navigate(R.id.action_guias_fragment_to_login_fragment);

            }
        });

        menuinfer = view.findViewById(R.id.fragment_menu_inferior);
        // ABRIR GUIAS

        botonguia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* HACER VISIBLE LA GUIA */

                guia1.setVisibility(View.VISIBLE);
                menuinfer.setVisibility(View.INVISIBLE);

            }
        });
        botonguia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* HACER VISIBLE LA GUIA */

                guia2.setVisibility(View.VISIBLE);
                menuinfer.setVisibility(View.INVISIBLE);

            }
        });
        botonguia3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* HACER VISIBLE LA GUIA */

                guia3.setVisibility(View.VISIBLE);
                menuinfer.setVisibility(View.INVISIBLE);

            }
        });
        botonguia4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* HACER VISIBLE LA GUIA */

                guia4.setVisibility(View.VISIBLE);
                menuinfer.setVisibility(View.INVISIBLE);

            }
        });
        botonguia5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* HACER VISIBLE LA GUIA */

                guia5.setVisibility(View.VISIBLE);
                menuinfer.setVisibility(View.INVISIBLE);

            }
        });
        botonguia6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* HACER VISIBLE LA GUIA */

                guia6.setVisibility(View.VISIBLE);
                menuinfer.setVisibility(View.INVISIBLE);

            }
        });

        // CERRAR LA GUIA

        cerrarguia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* HACER INVISIBLE LAS GUIAS */
                guia1.setVisibility(View.INVISIBLE);
                menuinfer.setVisibility(View.VISIBLE);
            }
        });
        cerrarguia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* HACER INVISIBLE LAS GUIAS */
                guia2.setVisibility(View.INVISIBLE);
                menuinfer.setVisibility(View.VISIBLE);
            }
        });
        cerrarguia3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* HACER INVISIBLE LAS GUIAS */
                guia3.setVisibility(View.INVISIBLE);
                menuinfer.setVisibility(View.VISIBLE);
            }
        });
        cerrarguia4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* HACER INVISIBLE LAS GUIAS */
                guia4.setVisibility(View.INVISIBLE);
                menuinfer.setVisibility(View.VISIBLE);
            }
        });
        cerrarguia5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* HACER INVISIBLE LAS GUIAS */
                guia5.setVisibility(View.INVISIBLE);
                menuinfer.setVisibility(View.VISIBLE);
            }
        });
        cerrarguia6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* HACER INVISIBLE LAS GUIAS */
                guia6.setVisibility(View.INVISIBLE);
                menuinfer.setVisibility(View.VISIBLE);
            }
        });
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