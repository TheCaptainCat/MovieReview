package fr.polytech.lechat.moviereview.categories;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.polytech.lechat.moviereview.R;
import fr.polytech.lechat.moviereview.list.MovieListActivity;

public class CategoryAdapter extends RecyclerView.Adapter {

    private List<Category> categories;
    private CategoriesActivity activity;
    private OnClick onClick;


    public CategoryAdapter(CategoriesActivity activity) {
        this.activity = activity;
        this.categories = Categories.getCategories();
        this.onClick = new OnClick();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,
                                                      int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_category, viewGroup, false);
        view.setOnClickListener(onClick);
        return new CategoryViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder,
                                 int i) {
        Category category = this.categories.get(i);
        if (viewHolder instanceof CategoryViewHolder && category != null) {
            ((CategoryViewHolder) viewHolder).setLayout(category);
        }
    }


    @Override
    public int getItemCount() {
        return this.categories.size();
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(activity, MovieListActivity.class);
            activity.startActivity(intent);
        }
    }
}
