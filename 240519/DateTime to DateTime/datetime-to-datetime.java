import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(calc(a, b, c));
    }

    public static int calc(int a, int b, int c){
        int dayDiff = a-11;
        int hourDiff = b-11;
        int minDiff = c-11;

        if(minDiff < 0){
            hourDiff -= 1;
            minDiff += 60;
        }
        if(hourDiff < 0){
            dayDiff -= 1;
            hourDiff += 24;
        }
        if(dayDiff < 0){
            return -1;
        }

        return dayDiff*24*60 + hourDiff*60 + minDiff;
    }
}