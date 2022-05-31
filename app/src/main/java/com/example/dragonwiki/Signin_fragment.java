package com.example.dragonwiki;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.royrodriguez.transitionbutton.TransitionButton;

public class Signin_fragment extends Fragment {

    TextView enlace;
    TransitionButton transitionButton;
    private EditText emailText, passwordText;
    private FirebaseAuth mAuth;

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
        transitionButton = view.findViewById(R.id.creacuenta);
        emailText = view.findViewById(R.id.email);
        passwordText = view.findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();

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
                crearCuenta();
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

    private void crearCuenta() {
        if (!validarFormulario()) {
            return;
        }
        transitionButton.setEnabled(false);

        mAuth.createUserWithEmailAndPassword(emailText.getText().toString(), passwordText.getText().toString())
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            actualizarUI(mAuth.getCurrentUser());
                        } else {
                            Snackbar.make(requireView(), "Usuario registrado correctamente", Snackbar.LENGTH_LONG).show();
                        }
                        transitionButton.setEnabled(true);
                    }
                });
    }

    private void actualizarUI(FirebaseUser currentUser) {
        if(currentUser != null){
            navController.navigate(R.id.action_signin_fragment_to_menu_fragment);
        }
    }

    private boolean validarFormulario() {
        boolean valid = true;

        if (TextUtils.isEmpty(emailText.getText().toString())) {
            emailText.setError("Required.");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (TextUtils.isEmpty(passwordText.getText().toString())) {
            passwordText.setError("Required.");
            valid = false;
        } else {
            passwordText.setError(null);
        }
        return valid;
    }
}