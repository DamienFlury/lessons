package ch.bbw.df;

public class DatabaseAccessFactory {

    public static IDatabaseAccess getAccessOn(String db) {
        switch(db) {
            case "MY_SQL":
                return new DatabaseAccess();
            case "ACCESS":
                return new DatabaseAccessMdb();
            default:
                return new DatabaseAccess();
        }
    }
}
