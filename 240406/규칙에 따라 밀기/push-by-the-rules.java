import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String command = sc.next();
        char[] commandArr = command.toCharArray();

        for(int i=0; i<commandArr.length; i++){
            if(commandArr[i] == 'L'){
                s = s.substring(1,s.length()) + s.substring(0,1);
            }
            else if(commandArr[i] == 'R'){
                s = s.substring(s.length()-1, s.length()) + s.substring(0, s.length()-1);
            }
        }

        System.out.println(s);
    }
}