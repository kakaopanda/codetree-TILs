import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            int answer = a;
            for(int j=a+1; j<=b; j++){
                answer *= j;
            }
            System.out.println(answer);
        }
    }
}