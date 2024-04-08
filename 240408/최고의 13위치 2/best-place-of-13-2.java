import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // 1. 첫번째 격자 선정
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-2; j++){
                int firstSum = 0;
                firstSum += arr[i][j] + arr[i][j+1] + arr[i][j+2];

                // 2. 두번째 격자 선정
                // (1). 동일한 행 내에서 2개의 격자를 선정하는 경우
                //if(){

                //}
                
                // (2). 서로 다른 행에서 2개의 격자를 선정하는 경우
                for(int n=i+1; n<arr.length; n++){
                    for(int m=0; m<arr.length-2; m++){
                        int secondSum = 0;
                        secondSum += arr[n][m] + arr[n][m+1] + arr[n][m+2];

                        max = Math.max(max, firstSum + secondSum);
                    }
                }
            }
        }
        
        System.out.println(max);
    }
}