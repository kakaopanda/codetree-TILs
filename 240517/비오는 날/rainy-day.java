import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Weather> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            Weather w = new Weather(sc.next(), sc.next(), sc.next());
            if(w.weather.equals("Rain")){
                list.add(w);
            }
        }
        Collections.sort(list);

        System.out.println(list.get(0));
    }
}

class Weather implements Comparable<Weather>{
    String date;
    String week;
    String weather;

    public Weather(String date, String week, String weather){
        this.date = date;
        this.week = week;
        this.weather = weather;
    }

    @Override
    public int compareTo(Weather o){
        return this.date.compareTo(o.date);
    }

    public String toString(){
        return date + " " + week + " " + weather;
    }
}