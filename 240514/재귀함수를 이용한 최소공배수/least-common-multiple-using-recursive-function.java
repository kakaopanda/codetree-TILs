import java.util.*;

public class Main {
    static int[] num = new int[11];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(lcm(0, arr));
    }

    public static int lcm(int index, int[] arr){
        if(index == arr.length){
            int mul = 1;
            for(int i=2; i<num.length; i++){
                while(num[i] >= 1){
                    mul *= i;
                    num[i] -= 1;
                }
            }
            return mul;
        }
        else{
            int n = arr[index];
            int div = 2;
            int cnt = 0;

            while(true){
                if(n <= 1){
                    return lcm(index+1, arr);
                }
                else{
                    if(n%div == 0){
                        cnt += 1;
                        if(cnt > num[div]){
                            num[div] = cnt;
                        }
                        n /= div;
                    }
                    else{
                        cnt = 0;
                        div += 1;
                    }
                }
            }
        }
    }
}