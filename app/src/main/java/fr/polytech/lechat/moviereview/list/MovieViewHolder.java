package fr.polytech.lechat.moviereview.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fr.polytech.lechat.moviereview.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView description;
    private ImageView image;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.movie_name);
        description = itemView.findViewById(R.id.movie_desc);
        image = itemView.findViewById(R.id.movie_img);
    }

    public void setLayout(Movie movie) {
        name.setText(movie.getName());
        description.setText(movie.getDescription());
        image.setImageResource(movie.getImgId());
    }
}
