package ch.bbw.df;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JokeFillerMdb {

    public static void fillJoke(Joke joke, ResultSet entry) throws SQLException {
        joke.setupJoke(
                entry.getInt("id"),
                entry.getString("text"),
                entry.getDate("date"),
                entry.getInt("rating")
        );
    }

    public static Joke createJokeObjectJavaIsACunt(ResultSet entry) throws SQLException {
        var joke = new Joke();
        fillJoke(joke, entry);
        return joke;
    }
}
