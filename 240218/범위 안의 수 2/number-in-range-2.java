import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int cnt = 0;
        
        for(int i=0; i<10; i++){
            int n = sc.nextInt();
            if(n>=0 && n<=200){
                sum += n;
                cnt += 1;
            }
        }
        System.out.printf("%d %.1f", sum, (double)sum/cnt);
    }
}