import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            char[] arr = s.toCharArray();
            int query = sc.nextInt();
            if(query == 1){
                int indexA = sc.nextInt()-1;
                int indexB = sc.nextInt()-1;

                char a = arr[indexA];
                char b = arr[indexB];
                arr[indexA] = b;
                arr[indexB] = a;
                s = new String(arr);
            }
            else if(query == 2){
                String a = sc.next();
                String b = sc.next();
                s = s.replaceAll(a, b);
            }

            System.out.println(s);
        }
    }
}