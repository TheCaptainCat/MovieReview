package fr.polytech.lechat.moviereview.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import fr.polytech.lechat.moviereview.R;

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        RecyclerView recyclerView = findViewById(R.id.movie_list_recycler);
        recyclerView.setAdapter(new ListAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
