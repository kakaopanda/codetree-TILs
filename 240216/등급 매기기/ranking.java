import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        String s = "F";

        if(score >= 90){
            s = "A";
        }
        else if(score >= 80){
            s = "B";
        }
        else if(score >= 70){
            s = "C";
        }
        else if(score >= 60){
            s = "D";
        }
        System.out.println(s);
    }
}