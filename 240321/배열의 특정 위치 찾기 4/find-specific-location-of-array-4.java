import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        int index = -1;
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
            if(arr[i] == 0){
                index = i;
            }
        }

        int cnt = 0;
        int sum = 0;
        for(int i=0; i<index; i++){
            if(arr[i]%2 == 0){
                cnt += 1;
                sum += arr[i];
            }
        }
        System.out.print(cnt + " " + sum);
    }
}