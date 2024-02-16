import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "no";

        if(n>=3000){
            s = "book";
        }
        else if(n>=1000){
            s = "mask";
        }
        else if(n>=500){
            s = "pen";
        }
        System.out.println(s);
    }
}