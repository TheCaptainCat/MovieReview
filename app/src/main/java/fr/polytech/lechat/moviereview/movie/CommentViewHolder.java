package fr.polytech.lechat.moviereview.movie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.polytech.lechat.moviereview.R;

public class CommentViewHolder extends RecyclerView.ViewHolder {
    private TextView text;

    public CommentViewHolder(@NonNull View itemView) {
        super(itemView);

        text = itemView.findViewById(R.id.comment_text);
    }

    public void setLayout() {
    }
}
