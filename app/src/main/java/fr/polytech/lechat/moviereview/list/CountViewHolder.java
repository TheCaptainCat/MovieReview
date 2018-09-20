package fr.polytech.lechat.moviereview.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.polytech.lechat.moviereview.R;

public class CountViewHolder extends RecyclerView.ViewHolder {
    private TextView label;

    public CountViewHolder(@NonNull View itemView) {
        super(itemView);

        label = itemView.findViewById(R.id.count_label);
    }

    public void setLayout(Count count) {
        label.setText(String.valueOf(count.getCount()) + (count.getCount() > 1 ? " films" : " film"));
    }
}
