import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        User first = new User("codetree", 10);
        User second = new User(sc.next(), sc.nextInt());

        System.out.println(first);
        System.out.println(second);
    }
}

class User{
    String id;
    int level;

    public User(String id, int level){
        this.id = id;
        this.level = level;
    }

    @Override
    public String toString(){
        return "user " + this.id + " lv " + this.level;
    }
}