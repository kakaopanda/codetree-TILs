import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        String ab = s1+s2;
        String ba = s2+s1;

        System.out.println(Integer.parseInt(ab) + Integer.parseInt(ba));
    }
}