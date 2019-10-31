package ch.bbw.df.app;

import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        var manager = factory.createEntityManager();

        manager.getTransaction().begin();

        var employees = manager.createNamedQuery("Employee.findAll").getResultList();
        manager.getTransaction().commit();
        manager.close();
        factory.close();

        if(employees == null) {
            System.out.println("No employees found");
        } else {
            for(var employee: employees) {
                System.out.println(employee);
            }
        }
    }
}
