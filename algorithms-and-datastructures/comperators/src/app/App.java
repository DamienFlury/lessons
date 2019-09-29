package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        var data = Data.getData();
        Arrays.sort(data, new PersonComperator());
        System.out.println(Arrays.toString(data));
    }
}