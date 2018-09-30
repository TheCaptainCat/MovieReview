package fr.polytech.lechat.moviereview.list;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import fr.polytech.lechat.moviereview.movie.MovieActivity;
import fr.polytech.lechat.moviereview.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private RelativeLayout layout;
    private TextView name;
    private ImageView image;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        layout = itemView.findViewById(R.id.cell_list_layout);
        name = itemView.findViewById(R.id.cell_movie_name);
        image = itemView.findViewById(R.id.cell_movie_img);
    }

    public void setLayout(Movie movie, final MovieListActivity activity, final int id) {
        name.setText(movie.getName());
        image.setImageResource(movie.getImgId());
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, MovieActivity.class);
                intent.putExtra("id", id);
                activity.startActivity(intent);
            }
        });
    }
}
