public class Main {
    public static void main(String[] args) {
        int cnt = 0;
        for(int i=1; i<=19; i++){
            cnt = 0;
            for(int j=1; j<=19; j++){
                System.out.print(i + " * " + j + " = " + i*j);
                if(j==19){
                    System.out.println();
                    break;
                }
                if(cnt%2 == 0){
                    System.out.print(" / ");
                }
                else{
                    System.out.println();
                }
                cnt += 1;
            }
        }
    }
}