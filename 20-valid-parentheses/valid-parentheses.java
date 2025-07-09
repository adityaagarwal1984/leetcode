class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch= s.charAt(i);
            if(st.isEmpty() && ch==')')
            return false;
            if(st.isEmpty() && ch=='}')
            return false;
            if(st.isEmpty() && ch==']')
            return false;

            if(ch=='(' || ch=='{' || ch=='[')
            st.push(ch);
            if(!st.isEmpty() && ch==')')
            {
                if(st.peek()=='(')
                st.pop();
                else
                st.push(ch);

            }
            if(!st.isEmpty() && ch=='}')
            {
                if(st.peek()=='{')
                st.pop();
                else
                st.push(ch);

            }
            if(!st.isEmpty() && ch==']')
            {
                if(st.peek()=='[')
                st.pop();
                else
                st.push(ch);

            }
        }
        return st.isEmpty();
        
    }
}