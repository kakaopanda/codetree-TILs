import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        // 1. 최대합에 포함할 3개의 숫자 선정
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    // 2. 3개의 숫자를 더하는 과정에서 Carry 발생 여부 식별
                    if(!carryCheck(arr[i], arr[j], arr[k])){
                        // 3. Carry가 발생하지 않은 경우, max값 갱신
                        max = Math.max(max, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }

        if(max == Integer.MIN_VALUE){
            max = -1;
        }
        System.out.println(max);
    }

    static boolean carryCheck(int a, int b, int c){
        // 3개의 숫자를 모두 더했을 때 5자리 이상인 경우, 캐리가 발생한 경우이므로 종료
        if(Integer.toString(a+b+c).length() >= 5){
            return true;
        }
        else{
            // 각 자릿수별로 덧셈을 진행하여 캐리 발생 여부를 분석한다.
            char[] first = Integer.toString(a).toCharArray();
            char[] second = Integer.toString(b).toCharArray();
            char[] third = Integer.toString(c).toCharArray();

            int mv = Math.max(Math.max(a, b), c);
            String mvStr = Integer.toString(mv);

            // 가장 낮은 자리수부터 계산한다.
            for(int i=0; i<mvStr.length(); i++){
                int sum = 0;

                if(first.length > i){
                    sum += (int)(first[first.length-i-1] - '0');
                }
                if(second.length > i){
                    sum += (int)(second[second.length-i-1] - '0');
                }
                if(third.length > i){
                    sum += (int)(third[third.length-i-1] - '0');
                }

                if(sum >= 10){
                    return true;
                }
            }

            return false;
        }
    }
}