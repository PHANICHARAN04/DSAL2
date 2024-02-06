import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Entry{
    int n,lvl;
    public Entry(int n,int lvl){
        this.n=n;
        this.lvl=lvl;
    }
}
public class Bfs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Queue<Entry> q=new LinkedList<>();
        q.add(new Entry(n, 0));
        while(!q.isEmpty()){
            Entry e = q.remove();
            if(e.n==1){
                System.out.println(e.lvl);
                break;
            }
            if(e.n%2==0){
                q.add(new Entry(e.n/2, e.lvl+1));
            }
            if(e.n%3==0){
                q.add(new Entry(e.n/3, e.lvl+1));
            }
            q.add(new Entry(e.n-1, e.lvl+1));
        }
    }
}
