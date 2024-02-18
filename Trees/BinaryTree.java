package Trees;

import java.util.*;
class Tree{
    Node root;
    class Node{
        Node left,right;
        int value;
        Node(int value){
            this.value=value;
        }
    }
    
    void insertRoot(){
        Scanner num=new Scanner(System.in);
        System.out.println("Enter root node:");
        int rootvalue=num.nextInt();
        root=new Node(rootvalue);
        populate(num,root);
    }
    
    void populate(Scanner num,Node current){
        System.out.println("To insert left of "+current.value);
        System.out.println("Enter true to add left else false: ");
        boolean left=num.nextBoolean();
        if(left){
            System.out.println("Enter node value:");
            int nodevalue=num.nextInt();
            current.left=new Node(nodevalue);
            populate(num,current.left);
        }
        System.out.println("To insert right of "+current.value);
        System.out.println("Enter true to add right else false: ");
        boolean right=num.nextBoolean();
        if(right){
            System.out.println("Enter node value:");
            int nodevalue=num.nextInt();
            current.right=new Node(nodevalue);
            populate(num,current.right);
        }
    }
    
    void display(Node current){
        if(current==null){
            return;
        }
        System.out.print(current.value+" ");
        display(current.left);
        display(current.right);
    }
}
public class BinaryTree{
	public static void main(String[] args) {
		Tree bt=new Tree();
		bt.insertRoot();
		bt.display(bt.root);
	}
}
