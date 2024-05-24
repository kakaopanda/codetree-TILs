import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int n = sc.nextInt();
        Coordinate[] arr = new Coordinate[n];

        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new Coordinate(x, y);
        }

        // 건너뛸 체크포인트 지정
        for(int i=1; i<n-1; i++){
            Coordinate start = arr[0];
            int d = 0;

            for(int j=0; j<n; j++){
                if(j == i){
                    continue;
                }
                else{
                    Coordinate end = arr[j];
                    d += distance(start.x, start.y, end.x, end.y);
                    start = end;
                }
            }

            min = Math.min(min, d);
        }
        
        System.out.println(min);
    }

    static int distance(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}

class Coordinate{
    int x;
    int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}