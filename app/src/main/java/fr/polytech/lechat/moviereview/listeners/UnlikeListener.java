package fr.polytech.lechat.moviereview.listeners;

import android.view.View;
import android.widget.Button;

import fr.polytech.lechat.moviereview.R;

public class UnlikeListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        v.setBackgroundResource(R.drawable.button);
        ((Button) v).setText(R.string.like);
        v.setOnClickListener(new LikeListener());
    }
}
