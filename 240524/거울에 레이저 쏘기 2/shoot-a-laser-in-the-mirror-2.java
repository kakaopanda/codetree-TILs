import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String[][] map = new String[N][N];
        
        // "/" 서(0), 북(1), 동(2), 남(3)
        int[][] deltaOne = {{0,-1},{-1,0},{0,1},{1,0}};

        // "\" 서(0), 남(1), 동(2), 북(3)
        int[][] deltaTwo = {{0,-1},{1,0},{0,1},{-1,0}};

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
        // (1). "/"
        // 1).서->북 2).북->동 3).동->남 4).남->서

        // (2). "\"
        // 1).서->남 2).남->동 3).동->북 4).북->서
        int cnt = 0;
        String output = "";
        while(isRange(r,c)){
            // System.out.println(r + "," + c + " 들어오는 방향 : " + dir);
            cnt += 1;

            // 최초 진입은 레이저의 방향을 결정할 때 출력 거울의 방향을 고려하지않는다.
            if(cnt != 1){
                String input = map[r][c];
                if(!output.equals(input)){
                    dir = changeLaser(dir, output);
                }
            }

            if(map[r][c].equals("/")){
                dir = (dir + 1) % 4;
                int dr = r + deltaOne[dir][0];
                int dc = c + deltaOne[dir][1];
                
                r = dr;
                c = dc;
                output = "/";
            }
            else if(map[r][c].equals("\\")){
                dir = (dir + 1) % 4;

                int dr = r + deltaTwo[dir][0];
                int dc = c + deltaTwo[dir][1];
                
                r = dr;
                c = dc;
                output = "\\";
            }

            // 레이저가 반사되어 나가는 방향이 서쪽, 동쪽일때
            // 들어오는 방향은 반대이므로 반전시켜줘야한다.
            if(dir%2 == 0){
                dir = (dir + 2) % 4;
            }
            // System.out.println(" 나가는 방향 : " + dir);
        }
        
        System.out.println(cnt);
    }

    public static boolean isRange(int r, int c){
        return (r>=0 && r<N && c>=0 && c<N);
    }

    // 서로 다른 거울에서 나온 방향을 교정해준다. (출력 거울의 방향 -> 입력 거울의 방향)
    public static int changeLaser(int k, String s){
        if(s.equals("/")){
            if(k == 0){
                return 0;
            }
            else if(k == 1){
                return 3;
            }
            else if(k == 2){
                return 2;
            }
            else if(k == 3){
                return 1;
            }
        }
        else if(s.equals("\\")){
            if(k == 0){
                return 0;
            }
            else if(k == 1){
                return 3;
            }
            else if(k == 2){
                return 2;
            }
            else if(k == 3){
                return 1;
            }
        }
        return -1;
    }

    public static int changeDirection(int k, String s){
        // 남서북동 -> 서북동남
        if(s.equals("/")){
            if(k == 0){
                return 3;
            }
            else if(k == 1){
                return 0;
            }
            else if(k == 2){
                return 1;
            }
            else if(k == 3){
                return 2;
            }
        }
        // 남서북동 -> 서남동북
        else if(s.equals("\\")){
            if(k == 0){
                return 1;
            }
            else if(k == 1){
                return 0;
            }
            else if(k == 2){
                return 3;
            }
            else if(k == 3){
                return 2;
            }
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