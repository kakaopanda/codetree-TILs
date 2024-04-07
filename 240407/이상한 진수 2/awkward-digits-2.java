import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] arr = a.toCharArray();

        boolean check = true;
        for(int i=1; i<arr.length; i++){
            if(arr[i] == '0'){
                arr[i] = '1';
                check = false;
                break;
            }
        }

        // 모든 수가 1로 이루어져 한번도 변환되지 않은 경우
        if(check){
            arr[arr.length-1] = '0';
        }

        System.out.println(Integer.parseInt(new String(arr),2));
    }
}