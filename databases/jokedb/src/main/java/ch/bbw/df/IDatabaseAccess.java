package ch.bbw.df;

import java.sql.SQLException;
import java.util.List;

public interface IDatabaseAccess {
    List<Joke> getAllJokes() throws SQLException, ClassNotFoundException;
}
