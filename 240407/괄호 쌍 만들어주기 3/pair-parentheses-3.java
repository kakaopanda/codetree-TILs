import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        // i : 여는 괄호의 위치, j : 닫는 괄호의 위치
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(Character.toString(s.charAt(i)).equals("(")){
                for(int j=i+1; j<s.length(); j++){
                    if(Character.toString(s.charAt(j)).equals(")")){
                        cnt += 1;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}