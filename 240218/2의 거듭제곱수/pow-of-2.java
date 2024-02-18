import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0;

        while(true){
            if(n == 1){
                break;
            }
            else{
                n /= 2;
                x += 1;
            }
        }
        System.out.println(x);
    }
}