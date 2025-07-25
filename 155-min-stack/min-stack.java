class MinStack {
    Stack<Integer> st;
    Stack<Integer> s;
    public MinStack() {
        st= new Stack<>();
        s=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(s.isEmpty() || val<=s.peek())
        s.push(val);
        
    }
    
    public void pop() {
       int num= st.pop();
       if(s.peek()==num)
       s.pop();
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        
        return s.peek();

        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */