import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int[] days = {31, 28, 31, 30, 31, 30,
                      31, 31, 30, 31, 30, 31};

        String[] week = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};

        // (m1, d1)을 기준으로, (m2, d2)가 기준보다 앞 날짜에 해당하는지, 뒷 날짜에 해당하는지 결정한다.
        int dayDiff = 0;
        if(m1 > m2){
            dayDiff += (days[m2-1] - d2);
            for(int i=m2+1; i<m1; i++){
                dayDiff += days[i-1];
            }
            dayDiff += d1;
        }
        // 뒷 날짜에 해당할 경우, DayDiff 기준을 0(일요일)으로 설정해뒀으므로 1을 추가해줘야한다.
        else if(m1 == m2){
            dayDiff += (d2 - d1 + 1);
        }
        else if(m1 < m2){
            dayDiff += (days[m1-1] - d1) + 1;
            for(int i=m1+1; i<m2; i++){
                dayDiff += days[i-1];
            }
            dayDiff += d2;
        }

        System.out.println(week[dayDiff%7]);
    }
}