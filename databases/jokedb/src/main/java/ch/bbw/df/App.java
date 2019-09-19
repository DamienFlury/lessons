package ch.bbw.df;


import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            System.out.println();

            System.out.println("MySql Data");
            System.out.println("===========");
            var dbAccessMySql = new DatabaseAccess();
            var jokeBook = new JokeBook(dbAccessMySql);
            jokeBook.print();

            System.out.println();

            System.out.println("Access Data");
            System.out.println("===========");
            var dbAccessAccess = new DatabaseAccessMdb();
            var jokeBook2 = new JokeBook(dbAccessAccess);
            jokeBook2.print();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
