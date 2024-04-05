import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        int num = 1;
        if(n <= m){
            for(int j=0; j<m; j++){
                int k = j;
                for(int i=0; i<n && i<=j; i++, k--){
                    arr[i][k] = num++;
                }
            }

            num = n*m;
            for(int j=m-1; j>=0; j--){
                int k = j;
                for(int i=n-1; i>=0 && k<m; i--, k++){
                    arr[i][k] = num--;
                }
            }
        }

        else{
            for(int j=0; j<m; j++){
                int k = j;
                for(int i=0; i<n && i<=j; i++, k--){
                    arr[i][k] = num++;
                }
            }

            for(int i=1; i<n; i++){
                int k = i;
                for(int j=m-1; j>=0 && k<n; j--, k++){
                    arr[k][j] = num++;
                }
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