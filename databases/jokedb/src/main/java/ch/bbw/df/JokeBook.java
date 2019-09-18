package ch.bbw.df;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JokeBook {
    private List<Joke> jokes;
    public JokeBook(IDatabaseAccess dao) throws SQLException, ClassNotFoundException {
        jokes = dao.getAllJokes();
    }

    public void print() {
        for(var joke: jokes) {
            joke.print();
        }
    }
}
