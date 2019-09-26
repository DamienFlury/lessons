package ch.bbw.df;

import java.util.List;

/**
 * Damien Flury
 * Version 1,0
 */
public interface IDatabaseAccess {
    List<Joke> getAllJokes();
    void addJoke(Joke joke);
    void removeJokeById(int id);
    void updateJokeById(int id, Joke joke);
}
