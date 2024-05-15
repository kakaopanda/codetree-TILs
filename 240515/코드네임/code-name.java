import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        for(int i=0; i<5; i++){
            list.add(new Student(sc.next(), sc.nextInt()));
        }
        Collections.sort(list);

        System.out.println(list.get(0));
    }
}

class Student implements Comparable<Student>{
    String name;
    int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString(){
        return this.name + " " + this.score;
    }

    @Override
    public int compareTo(Student o){
        return this.score - o.score;
    }
}