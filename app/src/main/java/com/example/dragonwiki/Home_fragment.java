package com.example.dragonwiki;

import static java.lang.Thread.sleep;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.util.TimeUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Home_fragment extends Fragment {

    Button botonSiguiente;


    Button carga;
    ProgressBar bProgreso;
    ImageView gif;
    TextView loading;

    boolean cargada = false;
    int i = 0;

    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        botonSiguiente = view.findViewById(R.id.cargando);
        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_home_fragment_to_login_fragment);
            }
        });

        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.barracarga);
        progressBar.setProgress(0);

        loading = view.findViewById(R.id.textocarga);
        gif = view.findViewById(R.id.gokuki);
        bProgreso = view.findViewById(R.id.barracarga);
        carga = view.findViewById(R.id.botoncarga);
        carga.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                bProgreso.setVisibility(View.VISIBLE);
                gif.setVisibility(View.VISIBLE);
                loading.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);

                Thread hilo = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int i = 0;
                        while (i != 5){
                            i++;
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                hilo.start();
            }
        });
    }
}