import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] score = new int[10001];
        int max = Integer.MIN_VALUE;

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i=0; i<n; i++){
            int index = sc.nextInt();
            String s = sc.next();
            
            if(s.equals("G")){
                score[index] = 1;
            }
            else if(s.equals("H")){
                score[index] = 2;
            }
        }

        for(int i=1; i<=score.length-k-1; i++){
            int sum = 0;

            for(int j=i; j<=i+k; j++){
                sum += score[j];
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}