package fr.polytech.lechat.moviereview.categories;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();

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
        categories.add(new Category("F"));
        categories.add(new Category("G"));

        return categories;
    }
}
