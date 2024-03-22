import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(true){
            int n = sc.nextInt();
            if(n == 999 || n == -999){
                break;
            }
            else{
                min = Math.min(min, n);
                max = Math.max(max, n);
            }
        }
        System.out.println(max + " " + min);
    }
}