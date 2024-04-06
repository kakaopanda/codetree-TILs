import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int previous = a.length();
        int after = 0;
        while(true){
            if(previous == after){
                break;
            }
            else{
                previous = a.length();
                a = a.replaceAll(b, "");
                after = a.length();
            }
        }

        System.out.println(a);
    }
}