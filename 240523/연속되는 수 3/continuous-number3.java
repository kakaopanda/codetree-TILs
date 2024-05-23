import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int cnt = 0;

        for(int i=0; i<arr.length; i++){
            if(i == 0){
                cnt = 1;
            }
            else if(arr[i-1]>0 && arr[i]>0){
                cnt += 1;
            }
            else if(arr[i-1]<0 && arr[i]<0){
                cnt += 1;
            }
            else{
                cnt = 1;
            }
            max = Math.max(cnt, max);
        }
        System.out.println(max);
    }
}