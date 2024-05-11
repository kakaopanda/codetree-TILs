import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        if(countAlpha(A)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

    public static boolean countAlpha(String str){
        if(str.length() < 2){
            return false;
        }
        else{
            for(int i=1; i<str.length(); i++){
                if(!str.substring(0,1).equals(str.substring(i,i+1))){
                    return true;
                }
            }
        }
        return false;
    }
}