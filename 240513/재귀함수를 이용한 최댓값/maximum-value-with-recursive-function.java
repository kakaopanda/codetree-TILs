import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(max(0, arr, 0));
    }

    public static int max(int index, int[] arr, int value){
        if(index == arr.length){
            return value;
        }
        else{
            if(arr[index] > value){
                value = arr[index];
            }
            return max(index+1, arr, value);
        }
    }
}