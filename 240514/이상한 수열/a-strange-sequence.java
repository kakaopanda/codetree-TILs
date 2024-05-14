import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(sequence(n));
    }

    public static int sequence(int n){
        if(n == 1){
            return 1;
        }
        else if(n == 2){
            return 2;
        }
        else{
            return sequence(n/3) + sequence(n-1);
        }
    }
}