package ch.bbw.df;

import javax.persistence.Persistence;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("FoodTracker starting...");
        var factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        var manager = factory.createEntityManager();

        manager.getTransaction().begin();
        var foods = manager.createNamedQuery("Food.findAll").getResultList();

        manager.close();
        factory.close();

        if(foods == null) {
            System.out.println("no employees found");
        } else {
            System.out.println(foods.size());
            System.out.println(foods.toString());
        }
    }
}
