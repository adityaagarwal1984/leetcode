
class Node
{
Node list[]= new Node[26];
boolean end;
public boolean contains(char ch)
{
    return list[ch-'a']!=null;
}
public Node get(char ch)
{
    return list[ch-'a'];
}
public void put(char ch,Node node)
{
    list[ch-'a']=node;
}
public void setEnd()
{
    end=true;
}
public boolean isEnd()
{
    return end;
}
}
    class Trie {
    private static Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.contains(word.charAt(i)))
            {
                char ch=word.charAt(i);
                node.put(ch,new Node());
            }
            node=node.get(word.charAt(i));
        }
        node.setEnd();
        
    }
    
    public boolean search(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
        if(!node.contains(word.charAt(i)))
        return false;
        node=node.get(word.charAt(i));
        }
        if(node.isEnd())
        return true;
        else
        return false;
    }
    
    public boolean startsWith(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.contains(word.charAt(i)))
            return false;
            node=node.get(word.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */