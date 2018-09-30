package fr.polytech.lechat.moviereview.listeners;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import fr.polytech.lechat.moviereview.movie.MovieActivity;

public class CommentListener implements View.OnClickListener {
    private EditText commentText;
    private MovieActivity movieActivity;

    public CommentListener(MovieActivity movieActivity, EditText commentText) {
        this.movieActivity = movieActivity;
        this.commentText = commentText;
    }

    @Override
    public void onClick(View v) {
        if (commentText.getText().toString().equals(""))
            return;
        Toast.makeText(movieActivity, commentText.getText(), Toast.LENGTH_SHORT).show();
        commentText.setText("");
    }
}
