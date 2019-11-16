package ch.bbw.df.foodtracker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import ch.bbw.df.foodtracker.models.Customer;
import ch.bbw.df.foodtracker.models.Food;

import java.util.ArrayList;
import java.util.List;

@Service
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

    public List<Customer> getCustomers() {
        return manager.createQuery("select c from Customer c").getResultList();
    }

    public Food createFood() {
        var customer = new Customer();
        customer.setName("Peter Parker");
        var food = new Food();
        food.setName("Apple");
        food.setPrice(2.50);
        var list = new ArrayList<Food>();
        list.add(food);
        // customer.setFood(list);

        manager.getTransaction().begin();
        var newCustomer = manager.merge(customer);
        food.setCustomer(newCustomer);
        var newFood = manager.merge(food);
        manager.getTransaction().commit();
        return newFood;

    }

    @Override
    public void close() throws Exception {
        manager.close();
        factory.close();
    }
}
