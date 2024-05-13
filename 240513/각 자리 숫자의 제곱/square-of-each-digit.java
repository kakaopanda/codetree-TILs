import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(pow(n));
    }

    public static int pow(int n){
        if(n < 10){
            return n*n;
        }
        else{
            return pow(n/10) + (n%10)*(n%10);
        }
    }
}