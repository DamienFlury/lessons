package ch.bbw.df;

import java.util.List;

public interface IDatabaseAccess {
    List<Joke> getAllJokes();
    void addJoke(Joke joke);
    void removeJokeById(int id);
    void updateJokeById(int id, Joke joke);
}
