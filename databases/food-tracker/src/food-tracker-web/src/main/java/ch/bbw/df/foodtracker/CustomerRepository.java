package ch.bbw.df.foodtracker;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import ch.bbw.df.foodtracker.models.Customer;

@Service
public class CustomerRepository implements AutoCloseable {
    private final EntityManagerFactory factory;
    private final EntityManager manager;

    public CustomerRepository() {
        this.factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        this.manager = factory.createEntityManager();
    }

    public List<Customer> findAll() {
        return manager.createQuery("select c from Customer c").getResultList();
    }

    @Override
    public void close() throws Exception {
        manager.close();
        factory.close();
    }
}