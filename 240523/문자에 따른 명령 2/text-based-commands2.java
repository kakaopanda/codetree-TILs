import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dir = 3; // 동(0), 남(1), 서(2), 북(3) (x, y) 좌표계로 가정
        int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
        String s = sc.next();

        char[] command = s.toCharArray();
        int x = 0;
        int y = 0;

        for(int i=0; i<command.length; i++){
            switch(command[i]){
                case 'L':
                    dir = ((dir - 1) + 4) % 4; 
                    break;
                case 'R':
                    dir = (dir + 1) % 4;
                    break;
                case 'F':
                    x += delta[dir][0];
                    y += delta[dir][1];
                    break;
            }
        }

        System.out.println(x + " " + y);
    }
}