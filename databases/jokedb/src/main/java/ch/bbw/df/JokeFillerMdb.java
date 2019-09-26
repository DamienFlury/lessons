package ch.bbw.df;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Damien Flury
 * Version 1,0
 */
public class JokeFillerMdb {

    public static Joke getJoke(ResultSet entry) throws SQLException {
        return new Joke(
                entry.getInt("jokeId"),
                entry.getString("content"),
                entry.getDate("date"),
                entry.getInt("rating")
        );
    }
}
