package fr.polytech.lechat.moviereview.list;

import fr.polytech.lechat.moviereview.R;

public class Movie implements ListElement {
    private String key;
    private String name;
    private String description;
    private int imgId;


    public Movie(String key, String name, String description) {
        this(key, name, description, R.mipmap.yor_min);
    }


    public Movie(String key, String name, String description, int imgId) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.imgId = imgId;
    }


    public String getKey() {
        return key;
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
