import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        for(int i=0; i<10; i++){
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int cnt = 0;
        for(int i=0; i<10; i++){
            if(arr[i] < 250){
                sum += arr[i];
                cnt += 1;
            }
            else{
                break;
            }
        }
        System.out.printf("%d %.1f", sum, (double)(sum/cnt));
    }
}