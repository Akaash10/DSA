package Trees;
import java.util.*;
class Main{
    static Scanner num=new Scanner(System.in); 
    static Node root;
    static class Node{
        Node left,right;
        int value;
        Node(int value){
            this.value=value;
        }
    }
    
    public static void insert(boolean flag){
        if(flag==false){
            return;
        }
        System.out.println("Enter node value: ");
        if(root==null){
            root=insertValue(root,num.nextInt());
        }
        else{
            insertValue(root,num.nextInt());
        }
        System.out.println("Enter true to add : ");
        insert(num.nextBoolean());
    }
    
    public static Node insertValue(Node temp,int value){
        if(temp==null){
            return new Node(value);
        }
        if(value>temp.value){
            temp.right=insertValue(temp.right,value);
        }
        if(value<temp.value){
            temp.left=insertValue(temp.left,value);
        }
        return temp;
    }
    
    public static void delete(boolean flag){
        if(flag==false){
            return;
        }
        System.out.println("\nEnter value to Delete: ");
        int value=num.nextInt();
        if(root.value==value){
            root=deleteValue(root,value);
        }
        else{
            deleteValue(root,value);
        }
    }
    
    public static Node deleteValue(Node root,int value){
        if(root==null){
            return null;
        }
        if(root.value==value){
            if(root.left==null&&root.right==null){
                return null;
            }
            else if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                root.value=findPredecessor(root.right);
                root.right=deleteValue(root.right,root.value);
                return root;
            }
        }
        if(value>root.value){
            root.right=deleteValue(root.right,value);
        }
        root.left=deleteValue(root.left,value);
        return root;
    }
    
    public static int findPredecessor(Node root){
        if(root.left==null){
            return root.value;
        }
        return findPredecessor(root.left);
    }
    
    public static void preOrderDisplay(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.value+" ");
        preOrderDisplay(root.left);
        preOrderDisplay(root.right);
    }
    
    public static void inOrderDisplay(Node root){
        if(root==null){
            return;
        }
        inOrderDisplay(root.left);
        System.out.print(root.value+" ");
        inOrderDisplay(root.right);
    }
    
    public static void inOrderDisplay(Node root,ArrayList<Integer>al){
        if(root==null){
            return;
        }
        inOrderDisplay(root.left,al);
        al.add(root.value);
        inOrderDisplay(root.right,al);
    }
    
    public static void postOrderDisplay(Node root){
        if(root==null){
            return;
        }
        postOrderDisplay(root.left);
        postOrderDisplay(root.right);
        System.out.print(root.value+" ");
    }
    
    public static void levelOrderDisplay(Node root){
        if(root==null){
            return;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.poll();
            System.out.print(temp.value+" ");
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
    }
    
    public static void spiralOrderDisplay(Node root){
        if(root==null){
            return;
        }
        Queue<Node>q=new LinkedList<>();
        ArrayList<Integer>al=new ArrayList<>();
        q.add(root);
        boolean signal=true;
        while(!q.isEmpty()){
            ArrayList<Integer>dup=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                Node temp=q.poll();
                dup.add(temp.value);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            if(!signal)
                Collections.reverse(dup);
            al.addAll(dup);
            signal=!signal;
        }
        System.out.print(al.toString().replaceAll("[\\[\\]\\,]",""));
    }
    
    public static boolean checkBalanced(Node root){
        if(root==null){
            return true;
        }
        return Math.abs(checkDepth(root.left)-checkDepth(root.right))<=1&&checkBalanced(root.left)&&checkBalanced(root.right);
    }
    
    public static int checkDepth(Node root){
        if(root==null){
            return 0;
        }
        int left=checkDepth(root.left);
        int right=checkDepth(root.right);
        if(left>right){
            return left+1;
        }
        return right+1;
    }
    
    public static int checkDepth(Node root,int key,int count){
        if(root==null){
            return -1;
        }
        if(root.value==key){
            return count;
        }
        if(key>root.value){
            return checkDepth(root.right,key,count+1);
        }
        return checkDepth(root.left,key,count+1);
    }
    
    public static boolean checkBst(Node root,int min,int max){
        if(root==null){
            return true;
        }
        if(root.value<=min||root.value>=max){
            return false;
        }
        return checkBst(root.left,min,root.value)&&checkBst(root.right,root.value,max);
    }
    
    public static int differnceBetweenNodes(Node root){
        ArrayList<Integer>al=new ArrayList<>();
        inOrderDisplay(root,al);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<al.size();i++){
            min=Math.min(min,al.get(i)-al.get(i-1));
        }
        return min;
    }
    
    public static Node findAncestor(Node root,int p,int q){
        if(root==null||root.value==p||root.value==q){
            return root;
        }
        if(p>root.value&&q>root.value){
            return findAncestor(root.right,p,q);
        }
        else if(p<root.value&&q<root.value){
            return findAncestor(root.left,p,q);
        }
        else{
            return root;
        }
    }
    
    public static int findDistance(Node root,int p,int q){
        Node n=findAncestor(root,p,q);
        int left=checkDepth(n,p,0);
        int right=checkDepth(n,q,0);
        int ans=left+right-(2*checkDepth(n,n.value,0));
        return ans;
    }
    
}
public class BinarySearchTree{
    public static void main(String[] args){
        Main bst=new Main();
        bst.insert(true);
        System.out.println("\nPreorder Display: ");
        bst.preOrderDisplay(bst.root);
        System.out.println("\nInorder Display: ");
        bst.inOrderDisplay(bst.root);
        System.out.println("\nPostorder Display: ");
        bst.postOrderDisplay(bst.root);
        System.out.println("\nLevelorder Display: ");
        bst.levelOrderDisplay(bst.root);
        System.out.println("\nSpiralorder Display: ");
        bst.spiralOrderDisplay(bst.root);
        
        System.out.println("\nBefore Deletion : ");
        bst.preOrderDisplay(bst.root);
        bst.delete(true);
        System.out.println("\nAfter Deletion : ");
        bst.preOrderDisplay(bst.root);
        
        System.out.println("\nDepth of Tree? : ");
        System.out.print(bst.checkDepth(bst.root));
        System.out.println("\nTree is balanced? : ");
        System.out.print(bst.checkBalanced(bst.root));
        System.out.println("\nTree is BST? : ");
        System.out.print(bst.checkBst(bst.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println("\nMinimum Difference between two nodes : ");
        System.out.print(bst.differnceBetweenNodes(bst.root));
        System.out.println("\nLowest common ancestor between two nodes : ");
        System.out.print(bst.findAncestor(bst.root,7,13).value);
        System.out.println("\nMinimum Distance between two nodes : ");
        System.out.print(bst.findDistance(bst.root,7,13));
    }
}