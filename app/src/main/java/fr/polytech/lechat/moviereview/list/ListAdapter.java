package fr.polytech.lechat.moviereview.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.polytech.lechat.moviereview.MovieManager;
import fr.polytech.lechat.moviereview.R;

public class ListAdapter extends RecyclerView.Adapter {
    private static final int MOVIE_ELEMENT = 0;
    private static final int LETTER_ELEMENT = 1;
    private static final int COUNT_ELEMENT = 2;

    private List<ListElement> elements;
    private MovieListActivity activity;


    public ListAdapter(MovieListActivity activity) {
        this.activity = activity;
        this.elements = ListAdapter.generateList();
    }


    @Override
    public int getItemViewType(int position) {
        if (elements != null) {
            ListElement element = elements.get(position);
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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup,
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
            return new MovieViewHolder(view);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder,
                                 int position) {
        ListElement element = this.elements.get(position);
        if (element != null && element.getType().equals(ListElementType.movie)) {
            ((MovieViewHolder) viewHolder).setLayout((Movie) element, activity, getMovieIdFromPosition(position));
        } else if (element != null && element.getType().equals(ListElementType.letter)) {
            ((LetterViewHolder) viewHolder).setLayout((Letter) element);
        } else if (element != null && element.getType().equals(ListElementType.count)) {
            ((CountViewHolder) viewHolder).setLayout((Count) element);
        }
    }


    @Override
    public int getItemCount() {
        if (elements != null)
            return elements.size();
        return 0;
    }

    public int getMovieIdFromPosition(int position) {
        if (elements.get(position) instanceof Movie)
            return ((Movie) elements.get(position)).getId();
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
}
