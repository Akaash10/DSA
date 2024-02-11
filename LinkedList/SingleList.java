package LinkedList;

class SinglyLinkedList{
    Node head,tail;
    int size;
    
    class Node{
        Node next;
        int value;
        Node(int value){
            this.value=value;
        }
    }
    
    void insert(int v){
        Node n=new Node(v);
        n.next=head;
        head=n;
        if(tail==null){
            tail=head;
        }
        size++;
    }
    
    void insertAtFirst(int v){
        Node n=new Node(v);
        n.next=head;
        head=n;
        size++;
    }
    
    void insertAtLast(int v){
        Node n=new Node(v);
        tail.next=n;
        tail=n;
        size++;
    }
    
    void insertAtSpecific(int value,int pos){
        Node temp=head;
        for(int i=0;i<pos-2;i++){
            temp=temp.next;
        }
        Node n=new Node(value);
        n.next=temp.next;
        temp.next=n;
        size++;
    }
    
    void deleteFirst(){
        head=head.next;    
        size--;
    }
    
    void deleteLast(){
        Node temp=head;
        for(int i=0;i<size-2;i++){
            temp=temp.next;
        }
        temp.next=null;
        size--;
    }
    
    void deleteAtSpecific(int pos) {
    	Node temp=head;
    	for(int i=0;i<pos-2;i++) {
    		temp=temp.next;
    	}
    	size--;
    	temp.next=temp.next.next;
    }
    
    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.print("END");
        System.out.println();
        System.out.println(size);
    }
}
public class SingleList{
    public static void main(String[] args){
        SinglyLinkedList l=new SinglyLinkedList();
        l.insert(10);
        l.insert(20);
        l.insert(30);
        l.insert(40);
        l.insertAtFirst(100);
        l.insertAtLast(80);
        l.display();
        l.insertAtSpecific(152,3);
        l.display();
        l.deleteFirst();
        l.display();
        l.deleteLast();
        l.display();
        l.deleteAtSpecific(3);
        l.display();
    }
}