import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        int T = sc.nextInt();

        Info[] arr = new Info[T];
        for(int i=0; i<T; i++){
            // t초에 x개발자와 y개발자가 악수를 나눴다.
            int t = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[i] = new Info(t, x, y);
        }
        Arrays.sort(arr);

        Person[] person = new Person[N+1];
        for(int i=1; i<=N; i++){
            int val = (i==P) ? 1 : 0;
            person[i] = new Person(K, val);
        }

        for(int i=0; i<arr.length; i++){
            int x = arr[i].x;
            int y = arr[i].y;

            if(person[x].infection==1 && person[y].infection==1){
                if(person[x].k > 0){
                    person[x].k -= 1;
                }
                if(person[y].k > 0){
                    person[y].k -= 1;
                }
            }
            else if(person[x].infection == 1){
                if(person[x].k > 0){
                    person[x].k -= 1;
                    person[y].infection = 1;
                }
            }
            else if(person[y].infection == 1){
                if(person[y].k > 0){
                    person[y].k -= 1;
                    person[x].infection = 1;
                }
            }
        }
        
        for(int i=1; i<person.length; i++){
            System.out.print(person[i].infection);
        }
    }
}

class Info implements Comparable<Info>{
    int t;
    int x;
    int y;

    public Info(int t, int x, int y){
        this.t = t;
        this.x = x;
        this.y = y;
    }
    
    // 악수를 나눈 시간순서대로 정렬한다.
    public int compareTo(Info o){
        return this.t - o.t;
    }
}

class Person{
    int k;
    int infection;

    public Person(int k, int i){
        this.k = k;
        infection = i;
    }
}