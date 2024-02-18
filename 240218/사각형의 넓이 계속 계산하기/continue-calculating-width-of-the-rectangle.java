import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            int width = sc.nextInt();
            int length = sc.nextInt();
            String s = sc.next();

            System.out.println(width * length);
            if(s.equals("C")){
                break;
            }
        }
    }
}