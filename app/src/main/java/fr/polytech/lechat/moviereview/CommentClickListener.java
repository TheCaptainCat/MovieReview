package fr.polytech.lechat.moviereview;

import android.view.View;
import android.widget.EditText;

public class CommentClickListener implements View.OnClickListener {
    private EditText commentText;


    public CommentClickListener(EditText commentText) {
        this.commentText = commentText;
    }


    @Override
    public void onClick(View v) {
        commentText.requestFocus();
    }
}
