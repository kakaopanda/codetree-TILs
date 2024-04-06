import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        char next = (char)(s.toCharArray()[0] + 1);
        if(next > 'z'){
            next = 'a';
        }
        System.out.println(next);
    }
}