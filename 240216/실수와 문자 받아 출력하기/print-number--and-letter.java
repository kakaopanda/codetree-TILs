import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        System.out.println(s.charAt(0));
        System.out.println((double)Math.round(a*100)/100);
        System.out.println((double)Math.round(b*100)/100);
    }
}