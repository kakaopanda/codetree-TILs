import java.util.*;

public class Main {
    static String[] week = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
    static int[] days = {0, 31, 29, 31, 30, 31, 30,
                       31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String w = sc.next();

        int cnt = 0;
        int monDiff = m2 - m1;
        int dayDiff = 0;

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<week.length; i++){
            map.put(week[i], i);
        }

        // 05.04 -> 06.03
        if(d1 > d2){
            monDiff -= 1;
            dayDiff += (days[m1] - d1);
            dayDiff += d2;
        }
        else{
            // 05.04 -> 05.05
            dayDiff += (d2 - d1);
        }

        for(int i=0; i<monDiff; i++){
            dayDiff += days[m1 + i];
        }
        int index = map.get(w);

        // 탐색하려는 요일이 최소 1번이상 등장하는 경우
        if(dayDiff >= index){
            do{
                cnt += 1;
                dayDiff -= 7;
            }while(dayDiff >= index);
        }
        
        System.out.println(cnt);
    }
}