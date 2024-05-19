import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int diff = 1;

        if(m1 == m2){
            diff = d2 - d1;
        }
        else if(m1 < m2){
            diff += days[m1] - d1;
            for(int i=m1+1; i<m2; i++){
                diff += days[i];
            }
            diff += d2;
        }

        System.out.println(diff);
    }
}