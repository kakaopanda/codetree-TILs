import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mid = sc.nextInt();
        int end = sc.nextInt();
        int prize = 0;

        if(mid >= 90){
            if(end >= 95){
                prize = 100000;
            }
            else if(end >= 90){
                prize = 50000;
            }
        }
        System.out.println(prize);
    }
}