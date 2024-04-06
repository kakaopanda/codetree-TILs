import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int sum = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch>='1' && ch<='9'){
                sum += (int)(ch-'0');
            }
        }
        
        System.out.println(sum);
    }
}