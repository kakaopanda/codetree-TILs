import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int cntEE = 0;
        int cntEB = 0;

        for(int i=0; i<s.length()-1; i++){
            if(s.substring(i,i+2).equals("ee")){
                cntEE += 1;
            }
            else if(s.substring(i,i+2).equals("eb")){
                cntEB += 1;
            }
        }
        
        System.out.println(cntEE + " " + cntEB);
    }
}