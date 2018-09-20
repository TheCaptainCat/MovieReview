package fr.polytech.lechat.moviereview.categories;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import fr.polytech.lechat.moviereview.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private TextView name;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.cat_name);
    }

    public void setLayout(Category category) {
        name.setText(category.getName());
    }
}
