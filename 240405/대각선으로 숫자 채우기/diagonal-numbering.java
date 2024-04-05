import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        // 00 -> 01,10 -> 02,11,20
        int num = 1; 
        for(int j=0; j<m; j++){
            int k = j;
            for(int i=0; i<n && i<=j; i++, k--){
                arr[i][k] = num++;
            }
        }

        num = n*m;
        for(int j=m-1; j>m/2; j--){
            int k = j;
            for(int i=n-1; i>=m; i--, k++){
                arr[i][k] = num--;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}