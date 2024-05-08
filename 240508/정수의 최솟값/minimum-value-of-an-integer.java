import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(min(a,b,c));
    }

    public static int min(int a, int b, int c){
        int first = Math.min(a, b);
        int second = Math.min(b, c);

        return Math.min(first, second);
    }
}