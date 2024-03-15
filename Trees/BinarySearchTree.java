package Trees;
import java.util.*;
class Tree {
    static Node root;

    class Node {
        Node left, right;
        int value, height;

        Node(int value) {
            this.value = value;
        }
    }

    void insert(Scanner num) {
        System.out.println("Enter root value: ");
        int rootvalue = num.nextInt();
        root = new Node(rootvalue);
        populate(num, root, true);
    }

    void populate(Scanner num, Node root, boolean opinion) {
        if (opinion == false) {
            return;
        }
        System.out.println("Enter true to add: ");
        boolean localopinion = num.nextBoolean();
        if (localopinion) {
            System.out.println("Enter node value: ");
            int value = num.nextInt();
            settle(root, value);
        }
        populate(num,root,localopinion);
    }

    int height(Node n) {
        if (n == null) {
            return -1;
        }
        return n.height;
    }

    Node settle(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = settle(root.left, value);
        }
        if (value > root.value) {
            root.right = settle(root.right, value);
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return root;
    }

    boolean isEmpty() {
        return root == null;
    }

    void display(Node root) {
        if (root == null) {
            return;
        }
        System.err.print(root.value + " ");
        display(root.left);
        display(root.right);
    }
    
    boolean findBalanced(Node n){
        if(n==null){
            return true;
        }
        return Math.abs(height(n.left)-height(n.right))<=1&&findBalanced(n.left)&&findBalanced(n.right);
    }

    public static Node delete(Node root,int value){
        if(root==null){
            return null;
        }
        if(root.value==value){
            if(root.left==null&&root.right==null){
                return null;
            }
            else if(root.left==null&&root.right!=null){
                return root.right;
            }
            else if(root.left!=null&&root.right==null){
                return root.left;
            }
            else{
                root.value=findMin(root.right);
                root.right=delete(root.right,root.value);
            }
        }
        if(root.value<value){
            root.right=delete(root.right,value);
        }
        if(root.value>value){
            root.left=delete(root.left,value);
        }
        return root;
    }
    
    public static int findMin(Node temp){
        if(temp.left==null){
            return temp.value;
        }
        return findMin(temp.left);
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        Tree bst = new Tree();
        bst.insert(num);
        bst.display(bst.root);
        bst.delete(bst.root,num.nextInt());
        System.out.println();
        System.out.println("Tree is empty? :"+bst.isEmpty());
        System.out.println("Height of tree? :"+bst.height(bst.root));
        System.out.println("Tree is balanced? :"+bst.findBalanced(bst.root));
    }
}