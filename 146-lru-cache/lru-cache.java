class LRUCache {
class node
{
    int key,val;
    node next,prev;
    node(int key,int val)
    {
        this.key=key;
        this.val=val;
    }
    
}
int capacity;
    HashMap<Integer,node> map;
    node head,tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map= new HashMap<>();
        head=new node(0,0);
        tail= new node(0,0);
        head.next=tail;
        tail.prev=head;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        return -1;
        node nn= map.get(key);
        remove(nn);
        addfirst(nn);
        return nn.val;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        remove(map.get(key));
        if(map.size()==capacity)
        remove(tail.prev);
        node newnode= new node(key,value);
        addfirst(newnode);


        
    }
    public void remove(node n)
    {
        map.remove(n.key);
        n.prev.next=n.next;
        n.next.prev=n.prev;

    }
    public void addfirst(node n)
    {
        map.put(n.key,n);
        
        n.next=head.next;
        n.prev=head;
        head.next.prev=n;
        head.next=n;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */