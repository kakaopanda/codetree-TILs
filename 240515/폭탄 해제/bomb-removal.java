import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(new Info(sc.next(), sc.next(), sc.nextInt()));
    }
}

class Info{
    String code;
    String color;
    int second;

    public Info(String code, String color, int second){
        this.code = code;
        this.color = color;
        this.second = second;
    }

    @Override
    public String toString(){
        return "code : " + this.code + "\n"
        + "color : " + this.color + "\n"
        + "second : " + this.second;
    }
}