import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        int oddSum = 0;
        int evenSum = 0;
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
            if(i%2 == 1){
                evenSum += arr[i];
            }
            else{
                oddSum += arr[i];
            }
        }
        System.out.println(Math.abs(oddSum-evenSum));
    }
}