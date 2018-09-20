package fr.polytech.lechat.moviereview.list;

public class Letter implements ListElement {
    private String label;


    public Letter(String label) {
        this.label = label;
    }


    public String getLabel() {
        return label;
    }


    @Override
    public ListElementType getType() {
        return ListElementType.letter;
    }
}
