import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double ft = 30.48;
        System.out.println((double)Math.round(n * ft * 10)/10);
    }
}