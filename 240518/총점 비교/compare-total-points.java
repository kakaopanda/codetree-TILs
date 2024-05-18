import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Student> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

class Student implements Comparable<Student>{
    String name;
    int kor;
    int eng;
    int mat;
    int sum;

    public Student(String n, int k, int e, int m){
        name = n;
        kor = k;
        eng = e;
        mat = m;
        sum = k + e + m;
    }

    @Override
    public int compareTo(Student o){
        return sum - o.sum;
    }

    @Override
    public String toString(){
        return name + " " + kor + " " + eng + " " + mat;
    }
}