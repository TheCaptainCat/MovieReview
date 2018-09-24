package fr.polytech.lechat.moviereview.list;

import fr.polytech.lechat.moviereview.R;

public class Movie implements ListElement {
    private String name;
    private String description;
    private int imgId;


    public Movie(String name, String description) {
        this(name, description, R.mipmap.yor);
    }


    public Movie(String name, String description, int imgId) {
        this.name = name;
        this.description = description;
        this.imgId = imgId;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


    public int getImgId() {
        return imgId;
    }


    @Override
    public ListElementType getType() {
        return ListElementType.movie;
    }
}
