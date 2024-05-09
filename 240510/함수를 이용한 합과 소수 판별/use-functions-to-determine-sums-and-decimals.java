import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int cnt = 0;
        for(int i=a; i<=b; i++){
            if(isTarget(i)){
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }

    public static boolean isTarget(int n){
        if(isPrime(n) && isEven(n)){
            return true;
        }
        return false;
    }

    public static boolean isPrime(int n){
        if(n == 1){
            return false;
        }
        else{
            for(int i=2; i<n; i++){
                if(n%i == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEven(int n){
        String str = Integer.toString(n);
        
        int sum = 0;
        for(int i=0; i<str.length(); i++){
            sum += str.charAt(i) - '0';
        }

        if(sum%2 == 0){
            return true;
        }

        return false;
    }
}