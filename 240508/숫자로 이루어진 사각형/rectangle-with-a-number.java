import java.util.*;

public class Main {
    static int N = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        print(n);
    }
    
    public static void print(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(N == 10){
                    N = 1;
                }
                System.out.print(N++ + " ");
            }
            System.out.println();
        }
    }
}