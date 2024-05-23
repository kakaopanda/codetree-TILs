import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int max = 1;
        int cnt = 1;
        for(int i=1; i<n; i++){
            if(arr[i] > arr[i-1]){
                cnt += 1;
            }
            else{
                cnt = 1;
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}