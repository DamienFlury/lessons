package foodtracker;

import foodtracker.models.Customer;
import foodtracker.models.Food;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class FoodRepository implements AutoCloseable {

    private final EntityManagerFactory factory;
    private final EntityManager manager;

    public FoodRepository() {
        this.factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        this.manager = factory.createEntityManager();
    }

    public Food findById(int id) {
        return manager.find(Food.class, id);
    }

    public List<Food> getAll() {
        return manager.createNamedQuery("Food.findAll").getResultList();
    }

    public Food createFood() {
        var customer = new Customer();
        customer.setName("LOL");
        var food = new Food();
        food.setName("Strawberry");
        food.setPrice(2.50);
        var list = new ArrayList<Food>();
        list.add(food);
        customer.setFood(list);

        manager.merge(food);
        manager.merge()

    }

    @Override
    public void close() throws Exception {
        manager.close();
        factory.close();
    }
}
