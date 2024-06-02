import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] f = new int[3];
        int[] s = new int[3];

        for(int i=0; i<f.length; i++){
            f[i] = sc.nextInt();
        }
        
        for(int i=0; i<s.length; i++){
            s[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if((Math.abs(f[0]-i)<=2 || i>=n+f[0]-2)
                    && (Math.abs(f[1]-j)<=2 || j>=n+f[1]-2)
                    && (Math.abs(f[2]-k)<=2 || k>=n+f[2]-2)){
                        cnt += 1;
                    }
                    else if((Math.abs(s[0]-i)<=2 || i>=n+s[0]-2)
                    && (Math.abs(s[1]-j)<=2 || j>=n+s[1]-2)
                    && (Math.abs(s[2]-k)<=2 || k>=n+s[2]-2)){
                        cnt += 1;
                    } 
                }
            }
        }

        System.out.println(cnt);
    }
}