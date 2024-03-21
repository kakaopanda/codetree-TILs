import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        double avg = 0;

        for(int i=0; i<10; i++){
            int n = sc.nextInt();
            if((i+1)%2 == 0){
                sum += n;
            }
            if((i+1)%3 == 0){
                avg += n;
            }
        }
        System.out.printf("%d %.1f", sum, avg/3);
    }
}