package ch.bbw.df;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Damien Flury
 * Version 1,0
 */
public class DatabaseAccess implements IDatabaseAccess {

    private static String connectionUrl = "jdbc:mysql://localhost/jokedb?serverTimezone=UTC";

    @Override
    public List<Joke> getAllJokes() {
        try (var connection = DriverManager.getConnection(connectionUrl, "testuser", "")) {
            try (var stmt = connection.createStatement()) {
                try (var entries = stmt.executeQuery("SELECT * FROM joke")) {
                    var result = new ArrayList<Joke>();
                    while (entries.next()) {
                        result.add(JokeFiller.getJoke(entries));
                    }
                    return result;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void addJoke(Joke joke) {
        var sql = "INSERT INTO joke (text, date, rating) VALUES (?, ?, ?)";
        try (var connection = DriverManager.getConnection(connectionUrl, "testuser", "")) {
            try (var statement = connection.prepareStatement(sql)) {
                statement.setString(1, joke.getText());
                statement.setDate(2, new Date(joke.getDate().getTime()));
                statement.setInt(3, joke.getRating());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeJokeById(int id) {
        try (var connection = DriverManager.getConnection(connectionUrl, "testuser", "")) {
                var sql = "DELETE from joke where id = ?";
                try (var statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, id);
                    statement.executeUpdate();
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateJokeById(int id, Joke joke) {
        try(var connection = DriverManager.getConnection(connectionUrl)) {
            var sql = "update joke set text = ?, date = ?, rating = ? where id = ?";
            try(var statement = connection.prepareStatement(sql)) {
                statement.setString(1, joke.getText());
                statement.setDate(2, new Date(joke.getDate().getTime()));
                statement.setInt(3, joke.getRating());
                statement.setInt(4, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
