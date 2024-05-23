import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dy = {0, -1, 1, 0}; // 서, 남, 북, 동
        int[] dx = {-1, 0, 0, 1}; // 서, 남, 북, 동
        
        int x = 0;
        int y = 0;
        for(int i=0; i<n; i++){
            String d = sc.next();
            int m = sc.nextInt();

            switch(d){
                case "W":
                    x += dx[0] * m;
                    break;
                case "S":
                    y += dy[1] * m;
                    break;
                case "N":
                    y += dy[2] * m;
                    break;
                case "E":
                    x += dx[3] * m;
                    break;
            }
        }

        System.out.println(x + " " + y);
    }
}