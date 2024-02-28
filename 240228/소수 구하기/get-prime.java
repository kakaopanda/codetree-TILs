import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=2; i<=n; i++){
            int sum = 0;
            if(i == 2){
                System.out.print(i + " ");
                continue;
            }
            for(int j=2; j<i; j++){
                if(i%j == 0){
                    sum += 1;
                }
            }
            if(sum < 1){
                System.out.print(i + " ");
            }
        }
    }
}