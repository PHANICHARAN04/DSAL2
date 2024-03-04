import java.util.*;

class CDLLNode{
    int key;
    int value;
    CDLLNode prev,next;

    public CDLLNode(int key,int value){
        this.key=key;
        this.value=value;
    }
}
public class CDLL {
    CDLLNode head=null;

    //insertAtBegin
    CDLLNode insertAtBegin(int key,int value){
        CDLLNode newNode = new CDLLNode(key, value);
        newNode.next=newNode;
        newNode.prev=newNode;
        if (head == null) {
            head = newNode;
        }
        else{
            CDLLNode last = head.prev;
            newNode.next=head;
            head.prev=newNode;
            newNode.prev=last;
            last.next=newNode;
            head=newNode;
        }
        return head;
    }

    //printALLNodes
    void  printAllNodes() {
        if(head==null){
            return;
        }
        CDLLNode last = head.prev;
        CDLLNode curr=head;
        while(true){
            System.out.print(curr.key+" - "+curr.value+" | ");
            if(curr==last){
                break;
            }
            curr=curr.next;
        }
        System.out.println();
    }

    //deleteLastNode
    CDLLNode deleteLastNode(){  //
        if(head==null){
            return null;
        }
        CDLLNode last = head.prev;
        if(head==last){
            head=null; //delete only node
        }
        else{
            last.prev.next=head;
            head.prev=last.prev;
        }
        return last;
    }

    //moveNodeInBeginning
    void moveNodeInBegin(CDLLNode node){
        if(node==head){
            return;
        }
        node.prev.next=node.next;
        node.next.prev=node.prev;

        CDLLNode last=head.prev;
        node.next=head;
        head.prev=node;
        node.prev=last;
        last.next=node;
        head=node;
    }
}
class Main{
    public static void main(String[] args) {
        // CDLL ll=new CDLL();
        // ll.insertAtBegin(1, 1);
        // ll.insertAtBegin(2, 2);
        // ll.insertAtBegin(5, 5);
        // ll.printAllNodes();
        // //ll.deleteLastNode();
        // ll.printAllNodes();

        LRUCache cache=new LRUCache(4);
        cache.put(1, 100);
        cache.put(1,500);
        cache.put(2,200);
        cache.put(3,200);
        System.out.println(cache.get(1));
        cache.put(4,400);
        System.out.println(cache.get(2));
    }
}

class LRUCache{
    int capacity;
    int n;  // no.of items in the cache
    CDLL dll;
    HashMap<Integer, CDLLNode> mp;
    public LRUCache(int cap){
        this.capacity=cap;
        this.n=0;
        this.dll=new CDLL();
        this.mp = new HashMap<>();
    }
    void put(int key,int val){
        if(mp.containsKey(key)){
            CDLLNode node=mp.get(key);
            node.value=val;
            dll.moveNodeInBegin(node);
            //just update same node's value - no change in n
        }
        else{
           if(n<capacity){
            CDLLNode node=dll.insertAtBegin(key, val);
            mp.put(key,node);
            n++;  //new node inserted to n++
           }
           else{ //one deleted, one inserted - no chnage in n
            CDLLNode last=dll.deleteLastNode();
            mp.remove(last.key);
            CDLLNode node=dll.insertAtBegin(key, val);
            mp.put(key, node);
           }
        }
    }
    int  get(int key){
        if(mp.containsKey(key)){
            int ans=mp.get(key).value;
            dll.moveNodeInBegin(mp.get(key));
            return ans;
        }
        else{
            return -1;
        }
    }
}