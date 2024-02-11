package LinkedList;

class CircularLinkedList{
    Node head,tail;
    int size;
    class Node{
        Node next;
        int value;
        Node(int value){
            this.value=value;
        }
    }
    
    void insert(int value){
        Node n=new Node(value);
        n.next=head;
        head=n;
        if(tail!=null){
            tail.next=head;
        }
        else{
            tail=head;
        }
        size++;
    }
    
    void display(){
        Node temp=head;
        for(int i=0;i<size;i++){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("END");
    }
    
    int findPos(int val){
        Node temp=head;
        int dup=0;
        while(temp.value==val){
            temp=temp.next;
            dup++;
            break;
        }
        return dup;
    }
    void delete(int val){
        Node temp=head;
        int pos=findPos(val);
        for(int i=0;i<pos-2;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        size--;
    }
}
public class CircleList
{
	public static void main(String[] args) {
		CircularLinkedList c=new CircularLinkedList();
		c.insert(10);
		c.insert(11);
		c.insert(12);
		c.display();
		c.delete(11);
		c.display();
	}
}
