import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        int sum = 0;

        for(int i=min; i<=max; i++){
            if(i%5 == 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}