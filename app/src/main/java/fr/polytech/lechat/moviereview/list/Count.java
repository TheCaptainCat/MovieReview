package fr.polytech.lechat.moviereview.list;

public class Count implements ListElement {
    private int count;


    public Count(int count) {
        this.count = count;
    }


    public int getCount() {
        return count;
    }


    @Override
    public ListElementType getType() {
        return ListElementType.count;
    }
}
