package ch.bbw.df;


import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {

            var dbAccess = new DatabaseAccessMdb();
            var jokeBook = new JokeBook(dbAccess);
            jokeBook.print();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
