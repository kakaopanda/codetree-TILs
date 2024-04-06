import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String target = sc.next();
        int index = -1;

        for(int i=0; i<=s.length()-target.length(); i++){
            if(s.substring(i,i+target.length()).equals(target)){
                index = i;
                break;
            }
        }

        System.out.println(index);
    }
}