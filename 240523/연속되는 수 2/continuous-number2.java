import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int cnt = 0;

        for(int i=0; i<n; i++){
            if(i==0 || arr[i]==arr[i-1]){
                cnt += 1;
                max = Math.max(max, cnt);
            }
            else{
                cnt = 1;
            }
        }
        System.out.println(max);
    }
}