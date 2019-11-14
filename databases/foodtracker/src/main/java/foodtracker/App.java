package foodtracker;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        try(var repository = new FoodRepository()) {
            var foods = repository.getAll();
            var food = repository.findById(1);
            if(food == null) {
                System.out.println("no employees found");
            } else {
                System.out.println(food);
                System.out.println(food.toString());
            }
        } catch (Exception ex) {

        }


    }
}
