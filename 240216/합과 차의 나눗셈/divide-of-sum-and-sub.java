import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.printf("%.2f", (double)Math.round((double)(a+b)/(a-b)*100)/100);
    }
}