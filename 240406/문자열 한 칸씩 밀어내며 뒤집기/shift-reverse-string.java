import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int q = sc.nextInt();

        for(int i=0; i<q; i++){
            int query = sc.nextInt();
            
            if(query == 1){
                s = s.substring(1,s.length()) + s.substring(0,1);
            }
            else if(query == 2){
                s = s.substring(s.length()-1, s.length()) + s.substring(0, s.length()-1);
            }
            else if(query == 3){
                StringBuilder sb = new StringBuilder(s);
                s = sb.reverse().toString();
            }

            System.out.println(s);
        }
    }
}