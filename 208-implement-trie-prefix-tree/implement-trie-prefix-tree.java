class Node{
    Node links[]=new Node[26];
    boolean flag=false;

    public boolean containskey(char ch)
    {
        return links[ch-'a']!=null;
    }
    public Node get(char ch)
    {
        return links[ch-'a'];
    }
    public void put(char ch,Node node)
    {
        links[ch-'a']=node;
    }
    public void setend()
    {
        flag = true;
    }
    public boolean isend()
    {
        return flag;
    }
}
class Trie {
 private static Node root;
    public Trie() {
       root= new Node();

        
    }
    
    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.containskey(word.charAt(i)))
            {
                node.put(word.charAt(i),new Node());
            }
            node=node.get(word.charAt(i));
        }
        node.setend();
    }
    
    public boolean search(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.containskey(word.charAt(i)))
            {
                // node.put(word.charAt(i),new Node());
                return false;
            }
            node=node.get(word.charAt(i));
        }
        if(node.isend())
        return true;
        return false;
        
    }
    
    public boolean startsWith(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.containskey(word.charAt(i)))
            {
                // node.put(word.charAt(i),new Node());
                return false;
            }
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