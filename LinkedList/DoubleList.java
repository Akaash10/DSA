package LinkedList;

class DoublyLinkedList{
    Node head,tail;
    
    class Node{
        Node next,prev;
        int value;
        Node(int value){
            this.value=value;
        }
    }
    
    void insert(int value){
        Node n=new Node(value);
        n.next=head;
        if(head!=null){
            head.prev=n;
        }else{
            n.prev=null;
            tail=n;
        }
        head=n;
    }
    
    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.print("END");
        System.out.println();
    }
    
    void insertAtFirst(int value){
        Node n=new Node(value);
        n.next=head;
        head.prev=n;
        n.prev=null;
        head=n;
    }
    
    void insertAtLast(int value){
        Node n=new Node(value);
        tail.next=n;
        n.next=null;
        n.prev=tail;
        tail=n;
    }
    
    void insertAtSpecific(int pos,int value){
        Node temp=head;
        for(int i=0;i<pos-2;i++){
            temp=temp.next;
        }
        Node n=new Node(value);
        n.next=temp.next;
        temp.next.prev=n;
        temp.next=n;
        n.prev=temp;
    }
    
    void deleteFirst(){
        head=head.next;
        head.prev=null;
    }
    
    void deleteLast(){
        tail=tail.prev;
        tail.next=null;
    }
    
    void deleteAtSpecific(int pos){
        Node temp=head;
        for(int i=0;i<pos-2;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        temp.next.prev=temp;
    }
    
    void displayReverse(){
        Node temp=tail;
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.prev;
        }
        System.out.print("END");
    }
}
public class DoubleList{
	public static void main(String[] args) {
		DoublyLinkedList dl=new DoublyLinkedList();
		dl.insert(10);
		dl.insert(9);
		dl.insertAtFirst(8);
		dl.insertAtLast(11);
		dl.insertAtSpecific(3,13);
		dl.display();
		dl.deleteFirst();
		dl.display();
		dl.deleteLast();
		dl.display();
		dl.deleteAtSpecific(2);
		dl.display();
		dl.displayReverse();
	}
}
