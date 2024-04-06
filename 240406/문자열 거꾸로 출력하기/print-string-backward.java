import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true){
            String s = sc.next();
            if(s.equals("END")){
                break;
            }
            else{
                sb = new StringBuilder(s);
                System.out.println(sb.reverse().toString());
            }
        }
    }
}