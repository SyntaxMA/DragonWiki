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

public class Login_fragment extends Fragment {

    Button botonlogin;
    Button botonsignin;
    Button botongoogle;

    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        /* BOTÓN PARA IR AL LOGIN */

        botonlogin = view.findViewById(R.id.loginbutton);
        botonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_login_fragment_to_enter_fragment);            }
        });

        /* BOTÓN PARA IR AL SIGNIN */

        botonsignin = view.findViewById(R.id.signinbutton);
        botonsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_login_fragment_to_signin_fragment);            }
        });

        /* BOTÓN PARA IR AL LOGIN DE GOOGLE */

        botongoogle = view.findViewById(R.id.googlebutton);
        botongoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_login_fragment_to_google_Fragment);            }
        });
    }
}