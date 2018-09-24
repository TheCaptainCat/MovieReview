package fr.polytech.lechat.moviereview.list;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.polytech.lechat.moviereview.MovieActivity;
import fr.polytech.lechat.moviereview.MovieManager;
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
        this.onClick = new OnClick();
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
        List<Movie> movies = MovieManager.getMovies();

        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        List<ListElement> elements = new ArrayList<>();

        char last = '\0';
        int count = 0;
        for (Movie movie : movies) {
            char current =  movie.getName().charAt(0);

            if (last == '\0' || last != current) {
                if (count > 0) {
                    elements.add(new Count(count));
                    count = 0;
                }
                elements.add(new Letter(String.valueOf(current)));
            }

            elements.add(movie);
            count++;

            last = current;
        }
        if (count > 0) {
            elements.add(new Count(count));
        }

        return elements;
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(activity, MovieActivity.class);
            activity.startActivity(intent);
        }
    }
}
