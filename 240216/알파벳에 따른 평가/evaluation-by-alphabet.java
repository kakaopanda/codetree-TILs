import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String str = "Failure";

        if(s.equals("S")){
            str = "Superior";
        }
        else if(s.equals("A")){
            str = "Excellent";
        }
        else if(s.equals("B")){
            str = "Good";
        }
        else if(s.equals("C")){
            str = "Usually";
        }
        else if(s.equals("D")){
            str = "Effort";
        }
        System.out.println(str);
    }
}