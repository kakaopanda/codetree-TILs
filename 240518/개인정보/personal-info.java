import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> list = new ArrayList<>();

        for(int i=0; i<5; i++){
            list.add(new Person(sc.next(), sc.nextInt(), sc.nextDouble()));
        }
        Collections.sort(list, new Comparator<Person>(){
            @Override
            public int compare(Person a, Person b){
                return a.name.compareTo(b.name);
            }
        });

        System.out.println("name");
        for(int i=0; i<list.size(); i++){
            Person p = list.get(i);
            System.out.printf(p.name + " " + p.height + " %.1f\n", p.weight);
        }

        System.out.println();
        System.out.println("height");
        Collections.sort(list, new Comparator<Person>(){
            @Override
            public int compare(Person a, Person b){
                return b.height - a.height;
            }
        });
        for(int i=0; i<list.size(); i++){
            Person p = list.get(i);
            System.out.printf(p.name + " " + p.height + " %.1f\n", p.weight);
        }   
    }
}

class Person{
    String name;
    int height;
    double weight;

    public Person(String n, int h, double w){
        name = n;
        height = h;
        weight = w;
    }
}