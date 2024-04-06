import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<=n-3; j++){
                int sum = 0;
                for(int k=j; k<=j+2; k++){
                    sum += arr[i][k];
                }
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);
    }
}