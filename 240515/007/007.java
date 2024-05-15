import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Info i = new Info(sc.next(), sc.next(), sc.nextInt());

        System.out.println(i.toString());
    }
}

class Info{
    String code;
    String place;
    int time;

    public Info(String code, String place, int time){
        this.code = code;
        this.place = place;
        this.time = time;
    }

    @Override
    public String toString(){
        return "secret code : " + this.code + "\n"
        + "meeting point : " + this.place + "\n"
        + "time : " + this.time;
    }
}