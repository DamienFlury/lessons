package ch.bbw.df;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccessMdb implements IDatabaseAccess {

    private static String connectionUrl = "jdbc:ucanaccess:///home/damienflury/JokeDB.accdb";

    @Override
    public List<Joke> getAllJokes() {
        try(var connection = DriverManager.getConnection(connectionUrl)) {
            try(var statement = connection.createStatement()) {
                try(var resultSet = statement.executeQuery("select * from joke")) {
                    var result = new ArrayList<Joke>();
                    while(resultSet.next()){
                        result.add(JokeFillerMdb.getJoke(resultSet));
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
        var sql = "INSERT INTO joke (content, date, rating) VALUES (?, ?, ?)";
        try (var connection = DriverManager.getConnection(connectionUrl)) {
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
        try (var connection = DriverManager.getConnection(connectionUrl)) {
                var sql = "DELETE from joke where jokeId = ?";
                try (var statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, id);
                    statement.executeUpdate();
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
