import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        char previous = (char)(s.toCharArray()[0] - 1);
        if(previous < 'a'){
            previous = 'z';
        }
        System.out.println(previous);
    }
}