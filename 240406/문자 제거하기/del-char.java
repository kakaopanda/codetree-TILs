import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        while(true){
            if(s.length() == 1){
                break;
            }
            else{
                int index = sc.nextInt();
                if(index > s.length()-1){
                    index = s.length()-1;
                }
                s = s.substring(0,index) + s.substring(index+1, s.length());
            }

            System.out.println(s);
        }
    }
}