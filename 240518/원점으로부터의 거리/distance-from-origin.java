import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Coordinate> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new Coordinate(i+1, Math.abs(sc.nextInt()) + Math.abs(sc.nextInt())));
        }
        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).index);
        }
    }
}

class Coordinate implements Comparable<Coordinate>{
    int index;
    int distance;

    public Coordinate(int i, int d){
        index = i;
        distance = d;
    }

    @Override
    public int compareTo(Coordinate o){
        return this.distance - o.distance;
    }
}