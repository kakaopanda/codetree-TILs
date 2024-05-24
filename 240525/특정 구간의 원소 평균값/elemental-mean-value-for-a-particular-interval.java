import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){          
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum += arr[k];
                }
                double avg = (double)sum/(j-i+1);

                boolean check = false;
                for(int k=i; k<=j; k++){
                    if(avg == arr[k]){
                        check = true;
                        break;
                    }
                }

                if(check){
                    cnt += 1;
                }
            }
        }

        System.out.println(cnt);
    }
}