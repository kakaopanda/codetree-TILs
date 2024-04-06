import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();

        for(int i=arr.length-1; i>=0; i--){
            if(i%2 == 1){
                System.out.print(arr[i]);
            }
        }
    }
}