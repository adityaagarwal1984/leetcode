class LRUCache { // wewill use here doubly linked list and hashmap.
    class Node{
        int key,val;
        Node next,prev;
        Node(int k,int v)
        {
            key=k;
            val=v;
        }
    }
      private final int cap;
    private HashMap<Integer, Node> map;
    private Node head, tail;
    

    public LRUCache(int capacity) {

         this.cap=capacity;
         map= new HashMap<>();
         head= new Node(-1,-1);
         tail= new Node(-1,-1);
         head.next=tail;
         tail.prev=head;
    }
    private void insert(Node node)
    {
        node.next=head.next;
        node.prev=head;
        head.next=node;
        node.next.prev=node;


    }
    private  void remove(Node node)
    {
        node.prev.next=node.next;
        node.next.prev=node.prev;

    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        return -1;

        Node node=map.get(key);
        remove(node);
        insert(node);

        return node.val;
}
    
    public void put(int key, int value) {
         Node newnode= new Node(key,value);
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            node.val=value;
            remove(node);
            insert(node);
        }
        else
        {
            if(map.size()==cap)
            {
                Node temp=tail.prev;
                remove(temp);
                map.remove(temp.key);
            }
            insert(newnode);
            map.put(key,newnode);
            
        }

        }
        
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */