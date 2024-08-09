package Trie;

class Node{
    Node links[]=new Node[26];
    boolean flag=false;
    int endWord=0,countPrefix=0;
    
    boolean containsKey(char v){
        return links[v-'a']!=null;
    }

    void put(char v,Node root){
        links[v-'a']=root;
    }

    Node get(char v){
        return links[v-'a'];
    }

    void setFlag(){
        flag=true;
    }

    boolean getFlag(){
        return flag;
    }

    void incrementEndWord(){
        endWord++;
    }

    void decrementEndWord(){
        endWord--;
    }

    void incrementWordPrefix(){
        countPrefix++;
    }

    void decrementWordPrefix(){
        countPrefix--;
    }

}
class Trie{
    public Node root;
    Trie(){
        root=new Node();
    }

    public void insert(String s){
        Node dup=root;
        for(char v:s.toCharArray()){
            if(!dup.containsKey(v)){
                dup.put(v,new Node());
            }
            dup.incrementWordPrefix();
            dup=dup.get(v);
        }
        dup.incrementWordPrefix();
        dup.setFlag();
        dup.incrementEndWord();
    }
    
    public boolean search(String s){
        Node dup=root;
        for(char v:s.toCharArray()){
            if(!dup.containsKey(v)){
                return false;
            }
            dup=dup.get(v);
        }
        return dup.getFlag();
    }
    
    public boolean startsWith(String s){
        Node dup=root;
        for(char v:s.toCharArray()){
            if(!dup.containsKey(v)){
                return false;
            }
            dup=dup.get(v);
        }
        return true;
    }
    
    public int countWordEqualTo(String s){
        Node dup=root;
        for(char v:s.toCharArray()){
            if(!dup.containsKey(v)){
                return 0;
            }
            dup=dup.get(v);
        }
        return dup.endWord;
    }

    public int countWordsStartingWith(String s){
        Node dup=root;
        for(char v:s.toCharArray()){
            if(!dup.containsKey(v)){
                return 0;
            }
            dup=dup.get(v);
        }
        return dup.countPrefix;
    }

    public void erase(String s){
        Node dup=root;
        for(char v:s.toCharArray()){
            if(!dup.containsKey(v)){
                return;
            }
            dup.decrementWordPrefix();
            dup=dup.get(v);
        }
        dup.decrementWordPrefix();
        dup.decrementEndWord();
    }

}
public class Main {
    public static void main(String[] args) {
        Trie t=new Trie();
        t.insert("coding");
        t.insert("ninja");
        t.insert("ninja");
        System.out.println(t.countWordEqualTo("coding"));
        System.out.println(t.countWordsStartingWith("nin"));
        t.erase("coding");
        System.out.println(t.countWordEqualTo("coding"));
    }
}
