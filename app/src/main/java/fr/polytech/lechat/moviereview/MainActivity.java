package fr.polytech.lechat.moviereview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.likeBtn).setOnClickListener(new LikeListener());
        findViewById(R.id.commentBtn).setOnClickListener(
                new CommentClickListener((EditText) findViewById(R.id.commentText)));
        findViewById(R.id.sendBtn).setOnClickListener(
                new CommentListener(this, (EditText) findViewById(R.id.commentText)));
    }
}
