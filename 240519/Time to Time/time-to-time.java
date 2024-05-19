import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int c = sc.nextInt();
        int d = sc.nextInt();

        int time = 0;
        if(c>=a && d>=b){
            time += d - b;
            time += (c-a) * 60;
        }
        else if(c>=a && d<b){
            time += 60 - b + d;
            time += (c-a-1) * 60;
        }

        System.out.println(time);
    }
}