package fr.polytech.lechat.moviereview.movie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.polytech.lechat.moviereview.R;

public class CommentAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,
                                                      int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_comment, viewGroup, false);
        return new CommentViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder,
                                 int i) {
        if (viewHolder instanceof CommentViewHolder) {
            ((CommentViewHolder) viewHolder).setLayout();
        }
    }


    @Override
    public int getItemCount() {
        return 6;
    }
}
