package ch.bbw.df;

import java.util.Date;

public class Joke {
    private int id;
    private String text;
    private Date date;
    private int rating;

    public Joke(int id, String text, Date date, int rating) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.rating = rating;
    }

    public void print() {
        System.out.println(String.format("Joke id: %d, Text: %s, Date: %s, rating: %d", id, text, date, rating));
    }
}
