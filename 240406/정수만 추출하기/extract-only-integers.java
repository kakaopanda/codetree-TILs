import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)<'0' || s1.charAt(i)>'9'){
                s1 = s1.substring(0,i);
                break;
            }
        }

        String s2 = sc.next();
        for(int i=0; i<s2.length(); i++){
            if(s2.charAt(i)<'0' || s2.charAt(i)>'9'){
                s2 = s2.substring(0,i);
                break;
            }
        }

        System.out.println(Integer.parseInt(s1) + Integer.parseInt(s2));
    }
}