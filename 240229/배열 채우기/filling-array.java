import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        int index = arr.length-1;
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
            if(arr[i] == 0){
                index = i-1;
                break;
            }
        }

        for(int i=index; i>=0; i--){
            System.out.print(arr[i] + " ");
        }
    }
}