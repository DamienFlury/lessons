package app;

public class Person {

    public Person(String firstName, String lastName, double height, int age, int shoeSize) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.age = age;
        this.shoeSize = shoeSize;
    }

    private String firstName;
    private String lastName;
    private double height;
    private int age;
    private int shoeSize;

    public String getFirstName() {
        return firstName;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}