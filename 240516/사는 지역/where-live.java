import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Person> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new Person(sc.next(), sc.next(), sc.next()));
        }
        Collections.sort(list);

        System.out.println(list.get(list.size()-1));
    }
}

class Person implements Comparable<Person>{
    String name;
    String number;
    String area;

    public Person(String name, String number, String area){
        this.name = name;
        this.number = number;
        this.area = area;
    }

    public int compareTo(Person o){
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString(){
        return "name " + this.name + "\n"
        + "addr " + this.number + "\n"
        + "city " + this.area;
    }
}