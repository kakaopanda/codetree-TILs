import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch>='a' && ch<='z'){
                System.out.print((char)(ch-32));
            }
            else if(ch>='A' && ch<='Z'){
                System.out.print((char)(ch+32));
            }
        }
    }
}