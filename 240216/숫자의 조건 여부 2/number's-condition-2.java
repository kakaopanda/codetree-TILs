import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String s = "";

        if(a==5){
            s = "A";
        }
        else if(a%2==0){
            s = "B";
        }
        System.out.println(s);
    }
}