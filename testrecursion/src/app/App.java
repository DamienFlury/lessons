package app;

public class App {
    public static void main(String[] args) throws Exception {
        test();
    }
    private static void test() {
        System.out.println("Hey");
        test();
    }
}