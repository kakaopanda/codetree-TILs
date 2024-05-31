import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];

        int sum = 0;
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int min = Integer.MAX_VALUE;
        // 개발자 3명의 인덱스를 고르는 조합
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(i!=j){
                    for(int k=0; k<6; k++){
                        if(k!=i && k!=j){
                            int team = 0;

                            team += arr[i];
                            team += arr[j];
                            team += arr[k];

                            int sub = sum - team;
                            min = Math.min(min, Math.abs(sub-team));
                        }
                    }
                }
            }
        }

        System.out.println(min);
    }
}