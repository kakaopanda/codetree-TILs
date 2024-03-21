import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        String status = "";

        for(int i=0; i<3; i++){
            String symptom = sc.next();
            int temperature = sc.nextInt();
            if(symptom.equals("Y") && temperature>=37){
                arr[0] += 1;
            }
            else if(symptom.equals("N") && temperature>=37){
                arr[1] += 1;
            }
            else if(symptom.equals("Y") && temperature<37){
                arr[2] += 1;
            }
            else{
                arr[3] += 1;
            }
        }

        if(arr[0] >= 2){
            status = "E";
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print(status);
    }
}