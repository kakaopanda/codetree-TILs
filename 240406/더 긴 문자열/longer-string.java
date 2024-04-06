import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int max = Math.max(s1.length(), s2.length());

        if(s1.length() == s2.length()){
            System.out.println("same");
        }
        else if(max == s1.length()){
            System.out.println(s1 + " " + max);
        }
        else{
            System.out.println(s2 + " " + max);
        }
    }
}