import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 서(0), 남(1), 북(2), 동(3)
        int[][] delta = {{0,-1},{1,0},{-1,0},{0,1}};

        int time = 0;
        int r = 0;
        int c = 0;
        boolean escape = false;
            
        LOOP:
        for(int i=0; i<n; i++){
            int direction = direction(sc.next());
            int distance = sc.nextInt();

            while(distance > 0){
                r += delta[direction][0];
                c += delta[direction][1];
                distance -= 1;
                time += 1;

                if(r==0 && c==0){
                    escape = true;
                    break LOOP;
                }
            }
        }

        if(!escape){
            time = -1;
        }

        System.out.println(time);
    }

    public static int direction(String s){
        switch(s){
            case "W":
                return 0;
            case "S":
                return 1;
            case "N":
                return 2;
            case "E":
                return 3;
        }

        return -1;
    }
}