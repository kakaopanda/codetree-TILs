import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] arr = new int[N][N];

        // 동(0), 서(1), 남(2), 북(3)
        int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}}; 

        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                int val = 0;

                for(int d=0; d<4; d++){
                    int dx = i + delta[d][0];
                    int dy = j + delta[d][1];

                    if(isRange(dx, dy)){
                        if(arr[dx][dy] == 1){
                            val += 1;
                        }
                    }
                }

                if(val >= 3){
                    cnt += 1;
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean isRange(int x, int y){
        return (x>=0 && x<N && y>=0 && y<N);
    }
}