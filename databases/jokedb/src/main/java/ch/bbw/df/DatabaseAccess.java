package ch.bbw.df;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess implements IDatabaseAccess {
    @Override
    public List<Joke> getAllJokes() throws SQLException {
        var connectionUrl = "jdbc:mysql://localhost/jokedb?serverTimezone=UTC";
        var connection = DriverManager.getConnection(connectionUrl, "testuser", "");
        var stmt = connection.createStatement();
        var entries = stmt.executeQuery("SELECT * FROM joke");



        var result = new ArrayList<Joke>();
        while(entries.next()) {
            result.add(JokeFiller.getJoke(entries));
        }
        entries.close();
        stmt.close();
        connection.close();
        return result;
    }
}
