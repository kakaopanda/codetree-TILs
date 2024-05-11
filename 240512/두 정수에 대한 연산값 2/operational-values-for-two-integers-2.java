import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntWrapper a = new IntWrapper(sc.nextInt());
        IntWrapper b = new IntWrapper(sc.nextInt());

        change(a, b);

        System.out.println(a.value + " " + b.value);
    }

    public static void change(IntWrapper a, IntWrapper b){
        if(a.value > b.value){
            b.value += 10;
            a.value *= 2;
        }
        else{
            b.value *= 2;
            a.value += 10;
        }
    }
}

class IntWrapper{
    int value;

    public IntWrapper(int n){
        value = n;
    }
}