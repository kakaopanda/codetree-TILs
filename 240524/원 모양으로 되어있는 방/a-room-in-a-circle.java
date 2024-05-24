import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        // 출발하는 방 위치 선정
        for(int i=0; i<n; i++){
            int d = 0;

            // 방별 거리 계산
            // 1). (i>j) i번방 -> j번방 : n+j-i
            // 2). (i<j) i번방 -> j번방 : j-i
            for(int j=0; j<n; j++){
                if(i == j){
                    continue;
                }
                else{
                    if(i>j){
                        d += (n+j-i)*arr[j];
                    }
                    else{
                        d += (j-i)*arr[j];
                    }
                }
            }

            min = Math.min(min, d);
        }

        System.out.println(min);
    }
}