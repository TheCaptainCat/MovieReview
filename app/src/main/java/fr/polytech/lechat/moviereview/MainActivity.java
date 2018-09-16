package fr.polytech.lechat.moviereview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button likeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeBtn = findViewById(R.id.likeBtn);
        likeBtn.setOnClickListener(new LikeListener());
    }
}
