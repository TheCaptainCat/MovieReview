package fr.polytech.lechat.moviereview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import fr.polytech.lechat.moviereview.listeners.CommentClickListener;
import fr.polytech.lechat.moviereview.listeners.CommentListener;
import fr.polytech.lechat.moviereview.listeners.LikeListener;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        findViewById(R.id.likeBtn).setOnClickListener(new LikeListener());
        findViewById(R.id.commentBtn).setOnClickListener(
                new CommentClickListener((EditText) findViewById(R.id.commentText)));
        findViewById(R.id.sendBtn).setOnClickListener(
                new CommentListener(this, (EditText) findViewById(R.id.commentText)));

        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
