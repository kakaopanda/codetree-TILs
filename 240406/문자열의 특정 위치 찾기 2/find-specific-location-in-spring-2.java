import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = {"apple", "banana", "grape", "blueberry", "orange"};
        String s = sc.next();

        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(Character.toString(arr[i].charAt(2)).equals(s) || Character.toString(arr[i].charAt(3)).equals(s)){
                System.out.println(arr[i]);
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }
}