package ch.bbw.df;

import java.sql.ResultSet;
import java.sql.SQLException;

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
