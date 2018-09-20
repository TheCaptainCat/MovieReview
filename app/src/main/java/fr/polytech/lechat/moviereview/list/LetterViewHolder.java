package fr.polytech.lechat.moviereview.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.polytech.lechat.moviereview.R;

public class LetterViewHolder extends RecyclerView.ViewHolder {
    private TextView label;

    public LetterViewHolder(@NonNull View itemView) {
        super(itemView);

        label = itemView.findViewById(R.id.letter_label);
    }

    public void setLayout(Letter letter) {
        label.setText(letter.getLabel());
    }
}
