import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String[][] map = new String[N][N];

        // 서(0), 남(1), 북(2), 동(3)
        int[][] delta = {{0,-1},{1,0},{-1,0},{0,1}};

        for(int i=0; i<map.length; i++){
            String s = sc.next();
            for(int j=0; j<map[i].length; j++){
                map[i][j] = s.substring(j, j+1);
            }
        }

        int k = sc.nextInt();
        int dir = getDirection(k);
        int[] loc = getLocation(k);
        int r = loc[0];
        int c = loc[1];
        dir = changeDirection(dir, map[r][c]);
        
        // 레이저 발사 위치별 반사 유형
        // 1).서<->북 2).동<->남
        int cnt = 0;
        while(isRange(r,c)){
            cnt += 1;

            dir = (dir + 2) % 4;
            int dr = r + delta[dir][0];
            int dc = c + delta[dir][1];
                
            r = dr;
            c = dc;
        }
        
        System.out.println(cnt);
    }

    public static boolean isRange(int r, int c){
        return (r>=0 && r<N && c>=0 && c<N);
    }

    public static int changeDirection(int k, String s){
        // 남서북동 -> 서남북동
        if(k == 0){
            return 1;
        }
        else if(k == 1){
            return 0;
        }
        else if(k == 2){
            return 2;
        }
        else if(k == 3){
            return 3;
        }

        return -1;
    }

    public static int getDirection(int k){
        if(k <= N){ // 남쪽 방향(S)
            return 0;
        }
        else if(k <= 2*N){ // 서쪽 방향(E)
            return 1;
        }
        else if(k <= 3*N){ // 북쪽 방향(N)
            return 2;
        }
        else if(k <= 4*N){ // 동쪽 방향(S)
            return 3;
        }
        else{
            return -1;
        }
    }

    public static int[] getLocation(int k){
        int[] location = new int[2];

        if(k <= N){
            location[0] = 0;
            location[1] = k-1;
        }
        else if(k <= 2*N){
            location[0] = k-(N+1);
            location[1] = N-1;
        }
        else if(k <= 3*N){
            location[0] = N-1;
            location[1] = 3*N-k;
        }
        else if(k <= 4*N){
            location[0] = 4*N-k;
            location[1] = 0;
        }

        return location;
    }
}