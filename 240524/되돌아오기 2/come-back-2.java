import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] command = s.toCharArray();

        // 서(0), 북(1), 동(2), 남(3)
        int[][] delta = {{0,-1},{-1,0},{0,1},{1,0}};

        int r = 0;
        int c = 0;
        int dir = 1; // 북쪽
        int time = 0;
        boolean escape = false;

        for(int i=0; i<command.length; i++){
            switch(command[i]){
                case 'L':
                    dir = ((dir - 1) + 4) % 4;
                    break;
                case 'R':
                    dir = (dir + 1) % 4;
                    break;
                case 'F':
                    r += delta[dir][0];
                    c += delta[dir][1];
                    break;
            }

            time += 1;
            if(r==0 && c==0){
                escape = true;
                break;
            }
        }

        if(!escape){
            time = -1;
        }
        System.out.println(time);
    }
}