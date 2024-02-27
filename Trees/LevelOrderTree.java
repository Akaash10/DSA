package Trees;

import java.util.*;
class Tree {
    static Node root;
    class Node {
        Node left, right;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    void insert(int arr[]) {
        root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (i < arr.length) {
                temp.left = new Node(arr[i]);
                q.add(temp.left);
                i++;
            }
            if (i < arr.length) {
                temp.right = new Node(arr[i]);
                q.add(temp.right);
                i++;
            }
        }
    }

    public int findLevel(int search, Node root, int level) {
        if (root == null) {
            return -1;
        }
        if (root.value == search) {
            return level;
        }
        int left = findLevel(search, root.left, level + 1);
        int right = findLevel(search, root.right, level + 1);
        if (left != -1) {
            return left;
        }
        if (right != -1) {
            return right;
        }
        return -1;

    }
    static void printSpecificLevel(int level) {
        Queue<Node>q=new LinkedList<>();
        int currentlevel=0;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node temp=q.poll();
                if(currentlevel==level){
                    System.out.print(temp.value+" ");
                }
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            currentlevel++;
        }
    }
}

public class LevelOrderTree {
    public static void main(String[] args) {
        Tree t = new Tree();
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        t.insert(arr);
        int search=5;
        int level=t.findLevel(search,t.root,0);
        t.printSpecificLevel(level);
    }

}
