import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int min = Math.min(a,b);
        int max = Math.max(a,b);

        for(int i=max; i>=min; i--){
            System.out.print(i + " ");
        }
    }
}