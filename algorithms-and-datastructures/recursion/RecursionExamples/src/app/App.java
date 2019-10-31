package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(fibonacci(8));

    }

    private static boolean isPalindrome(char[] arr, int front, int rear) {
        if (rear - front <= 0)
            return true;
        if (arr[front] == arr[rear]) {
            return isPalindrome(arr, front + 1, rear - 1);
        }
        return false;
    }

    
    private static void reverse(char[] arr, int front, int rear) {
        if(rear - front <= 0) {
            return;
        }
        var temp = arr[front];
        arr[front] = arr[rear];
        arr[rear] = temp;
    
        reverse(arr, front + 1, rear - 1);
    }

    private static int gcd(int a, int b) {
        if(a < b) {
            return gcd(a, b, a);
        }
        return gcd(b, a, b);
    }

    private static int gcd(int a, int b, int gcd) {
        if(a % gcd == 0 && b % gcd == 0) {
            return gcd;
        }
        return gcd(a, b, gcd - 1);
    }

    private static int fibonacci(int number) {
        if(number <= 1) {
            return number;
        }
        return fibonacci(number - 1) + fibonacci(number -2);
    }

    private static <T extends Comparable> void quicksort(T[] arr) {
        if(arr.length == 2) {
            if(arr[0].compareTo(arr[1]) >= 1){
                var temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            }
            return;
        }
    }
}