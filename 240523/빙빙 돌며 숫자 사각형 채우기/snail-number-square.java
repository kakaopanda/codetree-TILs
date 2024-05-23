import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] map = new int[n][n];
        
        // 동(0), 남(1), 서(2), 북(3)
        int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0;

        // 동, 남, 서, 북을 반복하며 회전한다. (시계방향 90도 회전)
        int num = 1;
        int r = 0;
        int c = 0;
        map[r][c] = num++;

        while(num <= n*n){
            int dr = r + delta[dir][0];
            int dc = c + delta[dir][1];

            if(isRange(dr, dc) && map[dr][dc]==0){
                r = dr;
                c = dc;
                map[r][c] = num++;
            }
            else{
                dir = (dir + 1) % 4;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isRange(int r, int c){
        return (r>=0 && r<n && c>=0 && c<n);
    }
}