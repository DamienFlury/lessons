package app;

import java.util.Comparator;

public class PersonComperator implements Comparator<Person> {

    @Override
    public int compare(Person arg0, Person arg1) {
        var firstNameCompared = arg0.getFirstName().compareTo(arg1.getFirstName());
        return firstNameCompared == 0 ? arg0.getLastName().compareTo(arg1.getLastName()) : firstNameCompared;
    }

}