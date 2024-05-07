import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0; i<n; i++){
            print(m);
        }
    }

    public static void print(int n){
        for(int i=0; i<n; i++){
            System.out.print("1");
        }
        System.out.println();
    }
}