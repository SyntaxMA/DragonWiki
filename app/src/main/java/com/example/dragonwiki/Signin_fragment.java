package com.example.dragonwiki;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.royrodriguez.transitionbutton.TransitionButton;

public class Signin_fragment extends Fragment {

    TextView enlace;
    TransitionButton transitionButton;

    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        transitionButton = view.findViewById(R.id.login);

        /* BOTÓN PARA IR AL SIGN IN */

        enlace = view.findViewById(R.id.clickaccount);
        enlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_signin_fragment_to_enter_fragment);
            }
        });

        transitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the loading animation when the user tap the button
                transitionButton.startAnimation();

                // Do your networking task or background work here.
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        boolean isSuccessful = true;

                        // Choose a stop animation if your call was succesful or not
                        if (isSuccessful) {
                            transitionButton.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                                @Override
                                public void onAnimationStopEnd() {
                                    navController.navigate(R.id.action_signin_fragment_to_menu_fragment);
                                }
                            });
                        } else {
                            transitionButton.stopAnimation(TransitionButton.StopAnimationStyle.SHAKE, null);
                        }
                    }
                }, 2000);
            }
        });
    }
}