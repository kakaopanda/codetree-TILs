import java.util.*;

public class Main {
    static int[][] arr;
    static int answer;
    static int R;
    static int C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // (1,1) ~ (19,19) -> (0,0) ~ (18, 18)
        arr = new int[19][19];

        for(int i=0; i<19; i++){
            for(int j=0; j<19; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        bfs();

        // 승리여부 출력
        System.out.println(answer);

        // 가운데 위치한 바둑알의 가로줄 및 세로줄 번호 출력(세로,가로,대각선)
        System.out.println(R + " " + C);
    }

    static void bfs(){
        Queue<Coordinate> queue = new ArrayDeque<>();
        for(int i=0; i<19; i++){
            for(int j=0; j<19; j++){
                if(arr[i][j] != 0){
                    queue.offer(new Coordinate(i, j, arr[i][j],1));
                }
            }
        }

        while(!queue.isEmpty()){
            Coordinate c = queue.poll();
            int color = arr[c.x][c.y];

            if(c.cnt == 5){
                answer = c.val;
                colorCheck(c.x, c.y, c.val);
                break;
            }

            // 좌측 상단에서 우측 하단으로 진행하므로, 세 방향만 탐색하면 된다.
            // (1). 오른쪽 돌이 연속적인 경우
            if(check(c.x, c.y+1) && color == arr[c.x][c.y+1]){
                queue.offer(new Coordinate(c.x, c.y+1, arr[c.x][c.y+1], c.cnt+1));
            }
            // (2). 아래쪽 돌이 연속적인 경우
            else if(check(c.x+1, c.y) && color == arr[c.x+1][c.y]){
                queue.offer(new Coordinate(c.x+1, c.y, arr[c.x+1][c.y], c.cnt+1));
            }
            // (3). 오른쪽 아래 대각선 돌이 연속적인 경우
            else if(check(c.x+1, c.y+1) && color == arr[c.x+1][c.y+1]){
                queue.offer(new Coordinate(c.x+1, c.y+1, arr[c.x+1][c.y+1], c.cnt+1));
            }
        }
    }

    static boolean check(int x, int y){
        if(x>18 || y>18){
            return false;
        }
        else{
            return true;
        }
    }

    static void colorCheck(int x, int y, int c){
        // 1. 세로 방향으로 이어졌는지 확인
        if(x-4>=0 && arr[x-1][y]==c && arr[x-2][y]==c &&
        arr[x-3][y]==c && arr[x-4][y]==c){
            R = x-2+1;
            C = y+1;
            return;
        }

        // 2. 가로 방향으로 이어졌는지 확인
        if(y-4>=0 && arr[x][y-1]==c && arr[x][y-2]==c &&
        arr[x][y-3]==c && arr[x][y-4]==c){
            R = x+1;
            C = y-2+1;
            return;
        }

        // 3. 대각선 방향으로 이어졌는지 확인
        if(x-4>=0 && y-4>=0 && arr[x-1][y-1]==c && arr[x-2][y-2]==c &&
        arr[x-3][y-3]==c && arr[x-4][y-4]==c){
            R = x-2+1;
            C = y-2+1;
            return;
        }
    }
}

class Coordinate{
    int x;
    int y;
    int val;
    int cnt;

    public Coordinate(int x, int y, int val, int cnt){
        this.x = x;
        this.y = y;
        this.val = val;
        this.cnt = cnt;
    }
}