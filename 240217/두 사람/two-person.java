import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aAge = sc.nextInt();
        String aSex = sc.next();
        int bAge = sc.nextInt();
        String bSex = sc.next();
        int answer = 0;

        if(aAge >= 19 && aSex.equals("M")){
            answer = 1;
        }
        else if(bAge >= 19 && bSex.equals("M")){
            answer = 1;
        }
        System.out.println(answer);
    }
}