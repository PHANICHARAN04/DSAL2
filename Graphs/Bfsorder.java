import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Entry{
    int n,lvl;
    public Entry(int n,int lvl){
        this.n=n;
        this.lvl=lvl;
    }
}
public class Bfsorder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Queue<Entry> q=new LinkedList<>();
        //Declare a Map key:Entry, value:Entry
        Map<Entry,Entry> parent =new HashMap<>();
        //to reverse the output
        Stack<Integer> stk=new Stack<>();
        Entry newEntry = new Entry(n, 0);
        q.add(newEntry);
        parent.put(newEntry,null);
        while(!q.isEmpty()){
            Entry e = q.remove();
            if(e.n==1){
                Entry curr=e;
                while(curr!=null){
                    //System.out.println(curr.n+" ");
                    stk.push(curr.n);
                    curr=parent.get(curr);
                }
                break;
            }
            if(e.n%2==0){
                Entry child=new Entry(e.n/2, e.lvl+1);
                q.add(child);
                parent.put(child,e);
            }
            if(e.n%3==0){
                Entry child=new Entry(e.n/3, e.lvl+1);
                q.add(child);
                parent.put(child,e);
            }
            Entry child=new Entry(e.n-1, e.lvl+1);
            q.add(child);
            parent.put(child,e);
            
            
        }
        while(!stk.isEmpty()){
            System.out.print(stk.pop()+" ");
        }
    }
}
