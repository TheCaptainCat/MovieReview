package fr.polytech.lechat.moviereview;

import java.util.ArrayList;
import java.util.List;

import fr.polytech.lechat.moviereview.categories.Category;
import fr.polytech.lechat.moviereview.list.Movie;

public class MovieManager {
    private static MovieManager INSTANCE = null;

    private List<Category> categories;
    private List<Movie> movies;

    private MovieManager() {
        this.categories = new ArrayList<>();
        initCategories();
        this.movies = new ArrayList<>();
        initMovies();
    }

    public static MovieManager getInstance() {
        if (INSTANCE == null)
            INSTANCE = new MovieManager();
        return INSTANCE;
    }

    public static List<Category> getCategories() {
        return new ArrayList<>(getInstance().categories);
    }

    public static List<Movie> getMovies() {
        return new ArrayList<>(getInstance().movies);
    }

    private void initCategories() {
        categories.add(new Category("Action"));
        categories.add(new Category("Aventure"));
        categories.add(new Category("Romance"));
        categories.add(new Category("Animation"));
        categories.add(new Category("Historique"));
        categories.add(new Category("Science-Fiction"));
        categories.add(new Category("Anticipation"));
        categories.add(new Category("Biopic"));
        categories.add(new Category("Policier"));
        categories.add(new Category("Documentaire"));
        categories.add(new Category("Jeunesse"));
        categories.add(new Category("Drame"));
        categories.add(new Category("Comédie"));
        categories.add(new Category("Western"));
        categories.add(new Category("Pour adultes"));
    }

    private void initMovies() {
        movies.add(new Movie("Yor, le chasseur du futur", "", R.mipmap.yor));
        movies.add(new Movie("Turkish Star Wars", "", R.mipmap.turkishsw));
        movies.add(new Movie("Star Crash", "", R.mipmap.starcrash));
        movies.add(new Movie("Future Wars", "", R.mipmap.futurewars));
        movies.add(new Movie("Hologram Man", "", R.mipmap.hologram_man));
        movies.add(new Movie("Attack of the Super Monsters", "", R.mipmap.super_monsters));
        movies.add(new Movie("Le Colosse de Hong Kong", "", R.mipmap.colosse_hong_kong));
        movies.add(new Movie("Mad Mutilator", "", R.mipmap.mad_mutilator));
        movies.add(new Movie("American Cyborg", "", R.mipmap.american_cyborg));
        movies.add(new Movie("Robo Vampire", "", R.mipmap.robo_vampire));
        movies.add(new Movie("Adam and Eve Versus the Cannibals", "", R.mipmap.adam_eve));
        movies.add(new Movie("Dinosaur from the Deep", "", R.mipmap.dinosaur_deep));
        movies.add(new Movie("Iron Master", "", R.mipmap.iron_master));
        movies.add(new Movie("Mon Curé chez les Nudistes", "", R.mipmap.mon_cure));
        movies.add(new Movie("L'ile aux Femmes Nues", "", R.mipmap.lile));
        movies.add(new Movie("Infirmière de nuit", "", R.mipmap.infirmiere));
    }
}
