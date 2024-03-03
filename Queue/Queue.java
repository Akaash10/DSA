package Queue;

import java.util.Arrays;

class myException extends Exception{
    myException(String message){
        super(message);
    }
}

class myQueue{
    private int arr[];
    private static final int size=2;
    private int ptr=-1;

    myQueue(){
        this(size);
    }
    myQueue(int size){
        this.arr=new int[size];
    }

    public boolean isFull(){
        return ptr==arr.length-1;
    }

    public boolean isEmpty(){
        return ptr==-1;
    }

    void add(int value)throws myException{
        if(isFull()){
            int temp[]=new int[arr.length*2];
            for(int i=0;i<arr.length;i++){
                temp[i]=arr[i];
            }
            arr=temp;
        }
        arr[++ptr]=value;
    }

    int remove() throws myException{
        if(isEmpty()){
            throw new myException("Cannot remove from an empty queue");
        }
        int temp=arr[0];
        arr=Arrays.copyOfRange(arr, 1, arr.length);
        ptr--;
        return temp;
    }

    int peek()throws myException{
        if(isEmpty()){
            throw new myException("Cannot peek from an empty queue");
        }
        return arr[0];
    }

    void display() throws myException{
        if(isEmpty()){
            throw new myException("Cannot display an empty queue");
        }
        for(int i=0;i<=ptr;i++){
            System.out.print(arr[i]+"->");
        }
        System.out.println("END");
    }

    int size(){
        return ptr+1;
    }
}
public class Queue {
    public static void main(String[] args) throws myException {
        myQueue m=new myQueue();
        m.add(1);//offer
        m.add(2);
        m.add(3);
        m.add(4);
        m.add(5);
        m.display();
        System.out.println(m.peek());//element
        System.out.println(m.remove());//poll
        m.display();
        System.out.println(m.size());
    }
}
