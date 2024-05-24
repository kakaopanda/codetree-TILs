import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N];
        int min = Integer.MAX_VALUE;

        int sum = 0;
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                int diff = arr[i] + arr[j];
                min = Math.min(min, Math.abs(S-(sum-diff)));
            }
        }

        System.out.println(min);
    }
}