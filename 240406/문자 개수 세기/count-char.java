import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String alpha = sc.next();
        char[] arr = s.toCharArray();

        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(Character.toString(arr[i]).equals(alpha)){
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }
}