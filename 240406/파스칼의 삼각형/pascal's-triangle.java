import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        arr[0][0] = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                int leftUp = 0;
                if(i-1>=0 && j-1>=0){
                    leftUp = arr[i-1][j-1];
                }
                int up = 0;
                if(i-1>=0 && j>=0){
                    up = arr[i-1][j];
                }
                if(i>0){
                    arr[i][j] = leftUp + up;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}