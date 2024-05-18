import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Element> before = new ArrayList<>();
        ArrayList<Element> after = new ArrayList<>();
        for(int i=0; i<n; i++){
            before.add(new Element(i+1, sc.nextInt()));
            after.add(before.get(i));
        }
        Collections.sort(after);
        
        int index = 1;
        while(true){
            if(after.size() == 0){
                break;
            }
            else{
                Element e = after.get(0);
                after.remove(0);

                for(int i=0; i<before.size(); i++){
                    Element b = before.get(i);
                    if(!b.visited && e.value == b.value){
                        b.index = index++;
                        b.visited = true;
                    }
                }
            }
        }

        for(int i=0; i<before.size(); i++){
            System.out.print(before.get(i).index + " ");
        }
    }
}

class Element implements Comparable<Element>{
    int index;
    int value;
    boolean visited;

    public Element(int i, int v){
        index = i;
        value = v;
        visited = false;
    }

    @Override
    public int compareTo(Element o){
        if(this.value == o.value){
            return this.index - o.index;
        }
        return this.value - o.value;
    }
}