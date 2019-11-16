package foodtracker;

import foodtracker.models.Food;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( final String[] args ) throws Exception
    {
        try(var repository = new FoodRepository()) {
            final var food = repository.createFood();
            final var customers = repository.getCustomers();
            System.out.println(food);
            if(customers == null) {
                System.out.println("no employees found");
            } else {
                System.out.println("Here");
                System.out.println(customers.toString());
                // System.out.println(food.toString());
            }
        }


    }
}
