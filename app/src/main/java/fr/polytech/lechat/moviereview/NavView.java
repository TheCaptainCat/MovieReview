package fr.polytech.lechat.moviereview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NavView extends RelativeLayout {
    public NavView(Context context) {
        super(context);
        init(context, null);
    }

    public NavView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public NavView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public NavView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.view_nav, this);

        TextView pageTitleView = findViewById(R.id.pageTitle);
        Button backBtn = findViewById(R.id.backBtn);

        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.NavView, 0, 0);

            String pageTitle = array.getString(R.styleable.NavView_page_title);
            if (pageTitle != null) {
                pageTitleView.setText(pageTitle);
            }
            String backTitle = array.getString(R.styleable.NavView_back_title);
            if (backTitle != null) {
                backBtn.setText(backTitle);
            }

            array.recycle();
        }
    }
}
