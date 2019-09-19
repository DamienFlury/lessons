package ch.bbw.df;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JokeFiller {
    public static Joke getJoke(ResultSet entry) throws SQLException {
        return new Joke(
                entry.getInt("id"),
                entry.getString("text"),
                entry.getDate("date"),
                entry.getInt("rating")
        );
    }
}
