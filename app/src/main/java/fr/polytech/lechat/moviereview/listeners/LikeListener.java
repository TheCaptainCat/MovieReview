package fr.polytech.lechat.moviereview.listeners;

import android.view.View;
import android.widget.Button;

import fr.polytech.lechat.moviereview.R;

public class LikeListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        v.setBackgroundResource(R.drawable.clicked_btn);
        ((Button) v).setText(R.string.liked);
        v.setOnClickListener(new UnlikeListener());
    }
}
