import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        String compareA = a+b;
        String compareB = b+a;

        if(compareA.equals(compareB)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}