package fr.polytech.lechat.moviereview.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import fr.polytech.lechat.moviereview.R;
import fr.polytech.lechat.moviereview.categories.CategoriesActivity;

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        RecyclerView recyclerView = findViewById(R.id.movie_list_recycler);
        recyclerView.setAdapter(new ListAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final MovieListActivity activity = this;
        findViewById(R.id.list_cat_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, CategoriesActivity.class);
                activity.startActivity(intent);
            }
        });
    }
}
