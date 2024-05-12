import java.util.*;

public class Main {
    static int[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        A = new int[n];
        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();
        }

        for(int i=0; i<m; i++){
            int sum = 0;
            int start = sc.nextInt()-1;
            int end = sc.nextInt()-1;

            for(int j=start; j<=end; j++){
                sum += A[j];
            }
            System.out.println(sum);
        }
    }
}