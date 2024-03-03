package Stack;

public class Dynamicstack extends Stack {
    Dynamicstack(){
        super();
    }

    Dynamicstack(int size){
        super(size);
    }
    
    void push(int value) throws MyException{
        if(isFull()){
            int temp[]=new int[arr.length*2];
            for(int i=0;i<arr.length;i++){
                temp[i]=arr[i];
            }
            arr=temp;
        }
        super.push(value);
    }
}
