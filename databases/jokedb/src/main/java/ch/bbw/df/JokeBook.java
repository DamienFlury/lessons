package ch.bbw.df;

/**
 * Damien Flury
 * Version 1,0
 */
public class JokeBook {
    private IDatabaseAccess dao;
    public JokeBook(IDatabaseAccess dao) {
        this.dao = dao;
    }

    public void print() {
        var jokes = dao.getAllJokes();
        for(var joke: jokes) {
            joke.print();
        }
    }
}
