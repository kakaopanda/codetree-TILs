import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        String answer = "";

        if(y%4 == 0){
            answer = "true";
            if(y%100 == 0){
                answer = "false";
                if(y%400 == 0){
                    answer = "true";
                }
            }
        }
        else{
            answer = "false";
        }
        System.out.println(answer);      
    }
}