package com.example.dragonwiki;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.UUID;

public class NewCardFragment extends Fragment {

    Button publishButton;
    EditText cardConentEditText;
    EditText cardAtkEditText;
    EditText cardDefEditText;
    EditText cardHpEditText;

    NavController navController;
    public AppViewModel appViewModel;
    Uri mediaUri;
    String mediaTipo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_card, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        appViewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);

        publishButton = view.findViewById(R.id.publishButton);
        cardConentEditText = view.findViewById(R.id.cardContentEditText);
        cardAtkEditText = view.findViewById(R.id.cardAttackEditText);
        cardDefEditText = view.findViewById(R.id.cardDeffenceEditText);
        cardHpEditText = view.findViewById(R.id.cardVidaEditText);

        publishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                publicar();
            }
        });

        view.findViewById(R.id.imagen_galeria).setOnClickListener(v -> seleccionarImagen());

        appViewModel.mediaSeleccionado.observe(getViewLifecycleOwner(), media -> {
            this.mediaUri = media.uri;
            this.mediaTipo = media.tipo;
            Glide.with(this).load(media.uri).into((ImageView) view.findViewById(R.id.previsualizacion));
        });
    }
    private void publicar() {
        String cardContent = cardConentEditText.getText().toString();
        String cardAttack = cardAtkEditText.getText().toString();
        String cardDeffence = cardDefEditText.getText().toString();
        String cardVida = cardHpEditText.getText().toString();

        if(TextUtils.isEmpty(cardContent)){
            cardConentEditText.setError("Required");
            return;
        }
        publishButton.setEnabled(false);
        if (mediaTipo == null) {
            guardarEnFirestore(cardContent, cardAttack, cardDeffence, cardVida, null, null );
        }
        else
        {
            pujaIguardarEnFirestore(cardContent, cardAttack, cardDeffence, cardVida);
        }
    }
    private void guardarEnFirestore(String cardContent, String attackContent, String deffenceContent, String vidaContent, String mediaUrl, String mediaCompleto) {

        Card card = new Card(cardContent, attackContent, deffenceContent, vidaContent, mediaUrl, mediaCompleto, mediaTipo);
        FirebaseFirestore.getInstance().collection("cards")
                .add(card)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        navController.popBackStack();
                        appViewModel.setMediacardSeleccionado( null,null,null);

                        String chatId = documentReference.getId();
                        Log.v("CARTAS", chatId);
                        documentReference.update("id", chatId);
                    }
                });
    }
    private void pujaIguardarEnFirestore(final String cardName, String cardAtk, String cardDef, String cardHp) {
        FirebaseStorage.getInstance().getReference(mediaTipo + "/" +
                UUID.randomUUID())
                .putFile(mediaUri)
                .continueWithTask(task -> task.getResult().getStorage().getDownloadUrl()).addOnSuccessListener(url -> guardarEnFirestore(cardName, cardAtk , cardDef, cardHp, url.toString(), url.toString()));
    }
    private final ActivityResultLauncher<String> galeria =
            registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
                appViewModel.setMediacardSeleccionado(uri, uri ,mediaTipo);
            });
    private void seleccionarImagen() {
        mediaTipo = "image";
        galeria.launch("image/*");
    }
}