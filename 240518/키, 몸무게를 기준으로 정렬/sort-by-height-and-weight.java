import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<Person> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new Person(sc.next(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list, new Comparator<Person>(){
            @Override
            public int compare(Person a, Person b){
                if(a.height == b.height){
                    return b.weight - a.weight;
                }
                else{
                    return a.height - b.height;
                }
            }
        });

        for(int i=0; i<n; i++){
            System.out.println(list.get(i));
        }
    }
}

class Person{
    String name;
    int height;
    int weight;

    public Person(String n, int h, int w){
        name = n;
        height = h;
        weight = w;
    }

    @Override
    public String toString(){
        return name + " " + height + " " + weight;
    }
}