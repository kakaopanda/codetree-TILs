import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print(sum(n));
    }

    public static int sum(int n){
        if(n == 1){
            return 1;
        }
        else{
            return sum(n-1) + n;
        }
    }
}