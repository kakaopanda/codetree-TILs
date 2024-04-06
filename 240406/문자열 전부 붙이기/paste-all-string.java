import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "";

        for(int i=0; i<n; i++){
            s += sc.next();
        }
        System.out.println(s);
    }
}