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
            a.value += 25;
            b.value *= 2;
        }
        else{
            a.value *= 2;
            b.value += 25;
        }

        return;
    }
}

class IntWrapper{
    int value;

    public IntWrapper(int n){
        value = n;
    }
}