package fr.polytech.lechat.moviereview.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import fr.polytech.lechat.moviereview.MovieManager;
import fr.polytech.lechat.moviereview.R;
import fr.polytech.lechat.moviereview.list.Movie;
import fr.polytech.lechat.moviereview.listeners.CommentClickListener;
import fr.polytech.lechat.moviereview.listeners.CommentListener;
import fr.polytech.lechat.moviereview.listeners.LikeListener;

public class MovieActivity extends AppCompatActivity {
    private TextView name;
    private TextView originalName;
    private TextView description;
    private ImageView image;

    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        this.name = findViewById(R.id.movie_name);
        this.originalName = findViewById(R.id.movie_original_name);
        this.description = findViewById(R.id.movie_description);
        this.image = findViewById(R.id.movie_picture);

        findViewById(R.id.likeBtn).setOnClickListener(new LikeListener());
        findViewById(R.id.commentBtn).setOnClickListener(
                new CommentClickListener((EditText) findViewById(R.id.commentText)));
        findViewById(R.id.sendBtn).setOnClickListener(
                new CommentListener(this, (EditText) findViewById(R.id.commentText)));

        int id = getIntent().getIntExtra("id", 0);
        this.movie = MovieManager.getMovieById(id);
        this.name.setText(movie.getName());
        this.originalName.setText(movie.getName());
        this.image.setImageResource(movie.getImgId());

        RecyclerView recyclerView = findViewById(R.id.comment_list);
        recyclerView.setAdapter(new CommentAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
