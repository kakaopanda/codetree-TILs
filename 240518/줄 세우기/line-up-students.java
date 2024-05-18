import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Student> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new Student((i+1), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

class Student implements Comparable<Student>{
    int index;
    int height;
    int weight;

    public Student(int i, int h, int w){
        index = i;
        height = h;
        weight = w;
    }

    @Override
    public int compareTo(Student o){
        if(this.height == o.height){
            if(this.weight == o.weight){
                return this.index - o.index;
            }
            return o.weight - this.weight;
        }
        else{
            return o.height - this.height;
        }
    }

    @Override
    public String toString(){
        return height + " " + weight + " " + index;
    }
}