import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=n; i>0; i--){
            for(int j=i-1; j>0; j--){
                System.out.print(" ");
            }
            for(int j=n-i+1; j>0; j--){
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int i=1; i<n; i++){
            for(int j=i; j>0; j--){
                System.out.print(" ");
            }
            for(int j=n-i; j>0; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}