import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        int i = 1;
        while(true){
            if(cnt == 2){
                break;
            }
            else{
                int k = n * i++;
                System.out.print(k + " ");
                if(k%5 == 0){
                    cnt += 1;
                }
            }
        }
    }
}