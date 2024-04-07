import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        char[] arr = s.toCharArray();

        int cnt = 0;
        for(int i=0; i<arr.length-2; i++){
            if(arr[i] == 'C'){
                for(int j=i+1; j<arr.length-1; j++){
                    if(arr[j] == 'O'){
                        for(int k=j+1; k<arr.length; k++){
                            if(arr[k] == 'W'){
                                cnt += 1;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}