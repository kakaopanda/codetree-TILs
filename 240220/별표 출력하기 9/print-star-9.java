import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            for(int j=0; j<n-i; j++){
                System.out.print("  ");
            }
            for(int j=2*i-1; j>0; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}