import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        // 첫 번째 숫자 선택
        for(int i=0; i<n-3; i++){
            int temp = Integer.MIN_VALUE;

            // 두 번째 숫자 선택
            for(int j=i+2; j<n; j++){
                temp = Math.max(temp, arr[i]+arr[j]);
            }
            max = Math.max(temp, max);
        }

        System.out.println(max);
    }
}