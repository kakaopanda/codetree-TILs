import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int cnt = 0;
        for(int i=a; i<=b; i++){
            if(isTargetNumber(i)){
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }

    public static boolean isTargetNumber(int n){
        return (n%3 == 0) || isContainNumber(n);
    }

    public static boolean isContainNumber(int n){
        String num = Integer.toString(n);
        char[] array = num.toCharArray();

        for(int i=0; i<array.length; i++){
            if(array[i] == '3' || array[i] == '6' || array[i] == '9'){
                return true;
            }
        }
        return false;
    }
}