import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        print(n);
        reversePrint(n);
    }

    public static void print(int n){
        for(int i=1; i<=n; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void reversePrint(int n){
        for(int i=n; i>0; i--){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}