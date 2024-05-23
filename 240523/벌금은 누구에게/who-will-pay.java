import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        int answer = -1;
        for(int i=0; i<m; i++){
            int number = sc.nextInt();
            arr[number-1] += 1;

            if(arr[number-1] >= k){
                answer =  number;
                break;
            }
        }

        System.out.println(answer);
    }
}