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
        for(int i=0; i<=n-3; i++){
            int sum = 0;
            for(int j=i; j<i+3; j++){
                sum += arr[i][j];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}