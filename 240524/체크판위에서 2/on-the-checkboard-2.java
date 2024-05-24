import java.util.*;

public class Main {
    static String[][] arr;
    static int R, C;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        arr = new String[R][C];
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                arr[i][j] = sc.next();
            }
        }

        bfs();
        System.out.println(answer);
    }

    static void bfs(){
        Queue<Jump> queue = new ArrayDeque<>();
        queue.offer(new Jump(0,0,1));

        while(!queue.isEmpty()){
            Jump c = queue.poll();

            if(c.x==R-1 && c.y==C-1){
                if(c.cnt-2 == 2){
                    answer += 1;
                }
            }

            for(int i=c.x+1; i<R; i++){
                for(int j=c.y+1; j<C; j++){
                    if(!arr[c.x][c.y].equals(arr[i][j])){
                        queue.offer(new Jump(i,j,c.cnt+1));
                    }
                }
            }
        }
    }
}

class Jump{
    int x;
    int y;
    int cnt;
    
    public Jump(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}