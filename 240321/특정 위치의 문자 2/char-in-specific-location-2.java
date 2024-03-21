import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[10];

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.next();
        }
        System.out.println(arr[1] + " " + arr[4] + " " + arr[7]);
    }
}