import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int decimal = Integer.parseInt(s, 2) * 17;
        System.out.println(Integer.toBinaryString(decimal));
    }
}