import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Person> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new Person(sc.next(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

class Person implements Comparable<Person>{
    String name;
    int height;
    int weight;

    public Person(String n, int h, int w){
        name = n;
        height = h;
        weight = w;
    }

    @Override
    public int compareTo(Person o){
        return this.height - o.height;
    }

    @Override
    public String toString(){
        return name + " " + height + " " + weight;
    }
}