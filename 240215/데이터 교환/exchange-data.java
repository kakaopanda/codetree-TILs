public class Main {
    public static void main(String[] args) {
        int a = 5, b = 6, c = 7;
        int temp_a = a, temp_b = b;
        a = c;
        b = temp_a;
        c = temp_b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}