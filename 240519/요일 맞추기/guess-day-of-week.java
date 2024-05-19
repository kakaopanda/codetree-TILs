import java.util.*;

public class Main {
    static int[] days = {0, 31, 28, 31, 30, 31, 30,
                      31, 31, 30, 31, 30, 31};
    static String[] week = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
    static int dayDiff = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        // (m1, d1)을 기준으로, (m2, d2)가 기준보다 앞 날짜(역방향)에 해당하는지, 
        // 뒷 날짜(순방향)에 해당하는지 결정한다.

        // Case1. 순방향
        if(m1 < m2){
            count(m1, d1, m2, d2);
        }
        else if(m1 == m2){
            if(d1 <= d2){
                count(m1, d1, m2, d2);
            }
            // Case2. 역방향
            else{
                reverseCount(m1, d1, m2, d2);
            }
        }
        
        else{
            reverseCount(m1, d1, m2, d2);
        }
    }

    public static void count(int m1, int d1, int m2, int d2){
        // 05.04 -> 05.05
        if(m1 == m2){
            dayDiff += d2 - d1;
        }
        else if(m1 < m2){
            // 05.04 -> 06.03
            // 05.04 -> 06.05
            dayDiff += days[m1] - d1;
            dayDiff += d2;

            for(int i=m1+1; i<m2; i++){
                dayDiff += days[i];
            }
        }

        System.out.println(week[dayDiff%7]);
    }

    public static void reverseCount(int m1, int d1, int m2, int d2){
        // 05.04 <- 05.03
        if(m1 == m2){
            dayDiff += d1 - d2;
        }
        else if(m1 > m2){
            // 05.04 <- 04.03
            // 05.04 <- 04.05
            dayDiff += days[m2] - d2;
            dayDiff += d1;

            for(int i=m2+1; i<m1; i++){
                dayDiff += days[i];
            }
        }

        System.out.println(week[7 - (dayDiff%7)]);
    }
}