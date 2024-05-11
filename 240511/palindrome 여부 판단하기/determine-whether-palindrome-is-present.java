import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        if(isPalindrome(A)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

    public static boolean isPalindrome(String str){
        boolean result = true;
        for(int i=0; i<str.length()/2; i++){
            if(str.substring(i,i+1).equals(str.substring(str.length()-i-1, str.length()-i))){
                continue;
            }
            else{
                result = false;
                break;
            }
        }

        return result;
    }
}