import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new Product("codetree", 50));
        System.out.println(new Product(sc.next(), sc.nextInt()));
    }
}

class Product{
    String name;
    int code;

    public Product(String name, int code){
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString(){
        return "product " + this.code + " is " + this.name;
    }
}