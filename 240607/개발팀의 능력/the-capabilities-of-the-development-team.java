import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        int sum = 0;
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(i!=j){
                    for(int k=0; k<arr.length; k++){
                        if(k!=i && k!=j){
                            int first = arr[i] + arr[j];
                            int second = arr[k];
                            int third = sum - (first + second);

                            if(first!=second && second!=third && first!=third){
                                int max = Math.max(Math.max(first, second), Math.max(second, third));
                                int min = Math.min(Math.min(first, second), Math.min(second, third));

                                answer = Math.min(answer, max-min);
                            }
                        }
                    }
                }
            }
        }

        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }

        System.out.println(answer);
    }
}