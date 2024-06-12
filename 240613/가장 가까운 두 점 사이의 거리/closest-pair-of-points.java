import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j){
                    int distance = (arr[i][0] - arr[j][0]) * (arr[i][0] - arr[j][0])
                                    + (arr[i][1] - arr[j][1]) * (arr[i][1] - arr[j][1]);

                    min = Math.min(min, distance);
                }
            }
        }

        System.out.println(min);
    }
}