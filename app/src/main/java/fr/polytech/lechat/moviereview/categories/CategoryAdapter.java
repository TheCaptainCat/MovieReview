package fr.polytech.lechat.moviereview.categories;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.polytech.lechat.moviereview.R;

public class CategoryAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_category, viewGroup, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Category category = Categories.getCategories().get(i);
        if (viewHolder instanceof CategoryViewHolder && category != null) {
            ((CategoryViewHolder) viewHolder).setLayout(category);
        }
    }

    @Override
    public int getItemCount() {
        return Categories.getCategories().size();
    }
}
