import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(s);
        for(int i=0; i<s.length(); i++){
            s = s.substring(s.length()-1, s.length()) + s.substring(0, s.length()-1);
            System.out.println(s);
        }
    }
}