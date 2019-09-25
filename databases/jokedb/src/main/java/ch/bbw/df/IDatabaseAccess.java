package ch.bbw.df;

import java.sql.SQLException;
import java.util.List;

public interface IDatabaseAccess {
    List<Joke> getAllJokes();
    void addJoke(Joke joke);
    void removeJokeById(int id);
}
