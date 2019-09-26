package ch.bbw.df;

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
