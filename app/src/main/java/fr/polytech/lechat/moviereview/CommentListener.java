package fr.polytech.lechat.moviereview;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CommentListener implements View.OnClickListener {
    private EditText commentText;
    private MainActivity mainActivity;

    public CommentListener(MainActivity mainActivity, EditText commentText) {
        this.mainActivity = mainActivity;
        this.commentText = commentText;
    }

    @Override
    public void onClick(View v) {
        if (commentText.getText().toString().equals(""))
            return;
        Toast.makeText(mainActivity, commentText.getText(), Toast.LENGTH_SHORT).show();
        commentText.setText("");
    }
}
