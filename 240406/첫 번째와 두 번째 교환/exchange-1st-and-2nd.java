import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ch1 = s.substring(0,1);
        String ch2 = s.substring(1,2);

        s = s.replaceAll(ch1, "A");
        s = s.replaceAll(ch2, ch1);
        s = s.replaceAll("A", ch2);
        System.out.println(s);
    }
}