package com.example.dragonwiki;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Carta_fragment extends Fragment {
    ImageView imageView;
    TextView nombreView;
    TextView ataqueView;
    TextView defensaView;
    TextView vidaView;

    Button atrasimagen;

    NavController navController;
    public AppViewModel appViewModel;
    public Carta_fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carta, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        appViewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);

        imageView = view.findViewById(R.id.imageCarta);
        nombreView = view.findViewById(R.id.cardName);
        ataqueView = view.findViewById(R.id.numeroataque);
        defensaView = view.findViewById(R.id.numerodefensa);
        vidaView = view.findViewById(R.id.numerovida);

        atrasimagen = view.findViewById(R.id.atrascarta);
        atrasimagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.personajes_fragment);
            }
        });
        appViewModel.cardSeleccionado.observe(getViewLifecycleOwner(), card ->
        {
            Glide.with(requireView()).load(card.mediaCompleto).into(imageView);
        });
    }
}