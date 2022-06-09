package com.example.dragonwiki;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Noticias_fragment extends Fragment {
    NavController navController;
    public AppViewModel appViewModel;

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
        return inflater.inflate(R.layout.fragment_noticias, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Declarar las cartas

        RecyclerView newsRecyclerView = view.findViewById(R.id.newsRecyclerView);

        Query query = FirebaseFirestore.getInstance().collection("news");

        FirestoreRecyclerOptions<News> options = new FirestoreRecyclerOptions.Builder<News>()
                .setQuery(query, News.class)
                .setLifecycleOwner(this)
                .build();

        newsRecyclerView.setAdapter(new NewsAdapter(options));
        appViewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);
    }

    class NewsAdapter extends FirestoreRecyclerAdapter<News, NewsAdapter.NewViewHolder> {
        public NewsAdapter(@NonNull FirestoreRecyclerOptions<News> options) {
            super(options);
        }

        @NonNull
        @Override
        public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new NewViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_new, parent, false));
        }

        @Override
        protected void onBindViewHolder(@NonNull NewViewHolder holder, int position, @NonNull final News news) {
            if (news.mediaUrl != null) {
                Glide.with(getContext()).load(news.mediaUrl).into(holder.authorPhotoImageView);
            } else {
                Glide.with(getContext()).load(R.drawable.iconcartas).into(holder.authorPhotoImageView);
            }
            // Miniatura de media
            if (news.mediaUrl != null) {
                holder.authorPhotoImageView.setVisibility(View.VISIBLE);
                Glide.with(requireView()).load(news.mediaUrl).centerCrop().into(holder.authorPhotoImageView);
                holder.authorPhotoImageView.setOnClickListener(view -> {
                    appViewModel.noticiaSeleccionado.setValue(news);
                    navController.navigate(R.id.noticia_fragment);
                });
            } else {
                holder.authorPhotoImageView.setVisibility(View.VISIBLE);

            }
        }

        class NewViewHolder extends RecyclerView.ViewHolder {
            ImageView authorPhotoImageView;

            NewViewHolder(@NonNull View itemView) {
                super(itemView);
                authorPhotoImageView = itemView.findViewById(R.id.newsImageView);
            }
        }
    }
}