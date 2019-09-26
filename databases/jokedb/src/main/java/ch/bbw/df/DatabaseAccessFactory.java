package ch.bbw.df;

public class DatabaseAccessFactory {

    public static IDatabaseAccess getAccessOn(String db) {
        switch(db) {
            case "MY_SQL":
                return new DatabaseAccess();
            case "ACCESS":
                return new DatabaseAccessMdb();
            case "POSTGRES":
                return new DatabaseAccessPsql();
            default:
                return new DatabaseAccess();
        }
    }
}
