import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[1001];
        for(int i=0; i<n; i++){
            arr[sc.nextInt()]++;
        }

        int max = -1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] == 1){
                max = Math.max(max, i);
            }
        }
        System.out.println(max);
    }
}