import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;

        // i -> 모이는 집 선택, j -> 이동 거리 계산
        for(int i=0; i<n; i++){
            int cost = 0;

            for(int j=0; j<n; j++){
                cost += arr[j] * Math.abs(i-j);
            }

            min = Math.min(min, cost);
        }

        System.out.println(min);
    }
}