import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next().replaceAll("[a-zA-Z]","");
        String s2 = sc.next().replaceAll("[a-zA-Z]","");

        System.out.println(Integer.parseInt(s1) + Integer.parseInt(s2));
    }
}