package fr.polytech.lechat.moviereview.list;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.polytech.lechat.moviereview.MainActivity;
import fr.polytech.lechat.moviereview.R;

public class ListAdapter extends RecyclerView.Adapter {
    private static final int MOVIE_ELEMENT = 0;
    private static final int LETTER_ELEMENT = 1;
    private static final int COUNT_ELEMENT = 2;

    private List<ListElement> list;
    private MovieListActivity activity;
    private OnClick onClick;


    public ListAdapter(MovieListActivity activity) {
        this.activity = activity;
        this.list = ListAdapter.generateList();
    }


    @Override
    public int getItemViewType(int position) {
        if (list != null) {
            ListElement element = list.get(position);
            switch (element.getType()) {
                case movie:
                    return MOVIE_ELEMENT;
                case letter:
                    return LETTER_ELEMENT;
                case count:
                    return COUNT_ELEMENT;
            }
        }
        return MOVIE_ELEMENT;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,
                                                      int type) {
        View view;
        if (type == LETTER_ELEMENT) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.cell_list_letter, viewGroup, false);
            return new LetterViewHolder(view);
        } else if (type == COUNT_ELEMENT) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.cell_list_count, viewGroup, false);
            return new CountViewHolder(view);
        } else {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.cell_list_movie, viewGroup, false);
            view.setOnClickListener(onClick);
            return new MovieViewHolder(view);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder,
                                 int position) {
        ListElement element = this.list.get(position);
        if (element != null && element.getType().equals(ListElementType.movie)) {
            ((MovieViewHolder) viewHolder).setLayout((Movie) element);
        } else if (element != null && element.getType().equals(ListElementType.letter)) {
            ((LetterViewHolder) viewHolder).setLayout((Letter) element);
        } else if (element != null && element.getType().equals(ListElementType.count)) {
            ((CountViewHolder) viewHolder).setLayout((Count) element);
        }
    }


    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    public static List<ListElement> generateList() {
        List<ListElement> list = new ArrayList<>();

        list.add(new Letter("A"));
        list.add(new Movie("aa", "Yor", "The Hunter from the future"));
        list.add(new Movie("ab", "Yor", "The Hunter from the future"));
        list.add(new Count(2));

        list.add(new Letter("B"));
        list.add(new Movie("ba", "Yor", "The Hunter from the future"));
        list.add(new Movie("bb", "Yor", "The Hunter from the future"));
        list.add(new Count(2));

        list.add(new Letter("C"));
        list.add(new Movie("ca", "Yor", "The Hunter from the future"));
        list.add(new Count(1));

        list.add(new Letter("E"));
        list.add(new Movie("ea", "Yor", "The Hunter from the future"));
        list.add(new Movie("eb", "Yor", "The Hunter from the future"));
        list.add(new Movie("ec", "Yor", "The Hunter from the future"));
        list.add(new Count(3));

        list.add(new Letter("K"));
        list.add(new Movie("ka", "Yor", "The Hunter from the future"));
        list.add(new Movie("kb", "Yor", "The Hunter from the future"));
        list.add(new Count(2));

        list.add(new Letter("Y"));
        list.add(new Movie("ya", "Yor", "The Hunter from the future"));
        list.add(new Movie("yb", "Yor", "The Hunter from the future"));
        list.add(new Movie("yc", "Yor", "The Hunter from the future"));
        list.add(new Movie("yd", "Yor", "The Hunter from the future"));
        list.add(new Movie("ye", "Yor", "The Hunter from the future"));
        list.add(new Count(5));

        list.add(new Letter("Z"));
        list.add(new Movie("z", "Yor", "The Hunter from the future"));
        list.add(new Count(1));

        return list;
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
        }
    }
}
