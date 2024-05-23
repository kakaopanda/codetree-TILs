import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int max = 0;
        int cnt = (arr[0] > t) ? 1 : 0;
        for(int i=1; i<n; i++){
            if(arr[i] > t){
                if(arr[i] > arr[i-1]){
                    cnt += 1;
                }
                else{
                    cnt = 1;
                }
            }
            else{
                cnt = 0;
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}