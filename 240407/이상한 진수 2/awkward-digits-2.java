import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] arr = a.toCharArray();

        for(int i=1; i<arr.length; i++){
            if(arr[i] == '0'){
                arr[i] = '1';
                break;
            }
        }

        System.out.println(Integer.parseInt(new String(arr),2));
    }
}