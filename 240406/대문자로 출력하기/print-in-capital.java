import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                sb.append(Character.toString((char)(ch-32)));
            }
            else if(ch>='A' && ch<='Z'){
                sb.append(Character.toString(ch));
            }
        }
        
        System.out.println(sb);
    }
}