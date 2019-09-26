package ch.bbw.df;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
            System.out.println();

            System.out.println("MySql Data");
            System.out.println("===========");
            var dbAccessMySql = DatabaseAccessFactory.getAccessOn("MY_SQL");
            dbAccessMySql.addJoke(new Joke("OOOF", new Date(), 1));
            var jokeBook = new JokeBook(dbAccessMySql);
            dbAccessMySql.removeJokeById(1);
            jokeBook.print();

            System.out.println();

            System.out.println("Access Data");
            System.out.println("===========");
            var dbAccessAccess = DatabaseAccessFactory.getAccessOn("ACCESS");
            dbAccessAccess.addJoke(new Joke("MEME", new Date(), 1));
            dbAccessAccess.removeJokeById(0);
            var jokeBook2 = new JokeBook(dbAccessAccess);
            jokeBook2.print();

            System.out.println();
            System.out.println("Postgresql");
            System.out.println("======");

            var dbAccessPostgres = DatabaseAccessFactory.getAccessOn("POSTGRES");
            dbAccessPostgres.addJoke(new Joke("Meme", new Date(), 1));
            var jokeBook3 = new JokeBook(dbAccessPostgres);
            jokeBook3.print();

    }
}
