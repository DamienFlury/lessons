package ch.bbw.df;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccessMdb implements IDatabaseAccess {
    @Override
    public List<Joke> getAllJokes() throws ClassNotFoundException, SQLException {
        var db = "./JokeDB.accdb";
        var url = "jdbc:ucanaccess:///home/damienflury/JokeDB.accdb";
        var c= DriverManager.getConnection(url);
        var st=c.createStatement();
        var rs = st.executeQuery("select * from joke");
        var result = new ArrayList<Joke>();
        while(rs.next()){
            result.add(JokeFiller.getJoke(rs));
        }
        return result;
    }
}
