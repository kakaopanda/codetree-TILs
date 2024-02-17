import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String grade = "";

        for(int i=n; i<=100; i++){
            if(i<60){
                grade = "F";
            }
            else if(i<70){
                grade = "D";
            }
            else if(i<80){
                grade = "C";
            }
            else if(i<90){
                grade = "B";
            }
            else{
                grade = "A";
            }
            System.out.print(grade + " ");
        }
    }
}