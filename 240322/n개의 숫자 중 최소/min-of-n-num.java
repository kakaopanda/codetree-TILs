import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            min = Math.min(min, arr[i]);
        }

        for(int i=0; i<n; i++){
            if(arr[i] == min){
                cnt += 1;
            }
        }
        System.out.println(min + " " + cnt);
    }
}