import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            String s = sc.next();
            int length = s.length();
            
            max = Math.max(max, length);
            min = Math.min(min, length);           
        }
        
        System.out.println(max - min);
    }
}