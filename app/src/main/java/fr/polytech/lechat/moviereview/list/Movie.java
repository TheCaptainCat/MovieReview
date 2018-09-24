package fr.polytech.lechat.moviereview.list;

import fr.polytech.lechat.moviereview.R;

public class Movie implements ListElement {
    private int id;
    private String name;
    private String description;
    private int imgId;


    public Movie(int id, String name, String description) {
        this(id, name, description, R.mipmap.yor);
    }


    public Movie(int id, String name, String description, int imgId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgId = imgId;
    }

    public int getId() {
        return id;
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
