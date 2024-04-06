import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();

        for(int i=2; i<10; i++){
            System.out.print(arr[i]);
        }
    }
}