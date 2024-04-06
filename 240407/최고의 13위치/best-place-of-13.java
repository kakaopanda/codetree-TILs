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
            for(int r=0; r<=n-3; r++){
                int sum = 0;
                for(int c=r; c<=r+2; c++){
                    sum += arr[r][c];
                }
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);
    }
}