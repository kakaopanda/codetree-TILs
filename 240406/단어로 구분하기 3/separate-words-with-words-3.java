import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[10];
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

        for(int i=0; i<arr.length; i++){
            arr[i] = st.nextToken();
        }

        for(int i=arr.length-1; i>=0; i--){
            System.out.println(arr[i]);
        }
    }
}