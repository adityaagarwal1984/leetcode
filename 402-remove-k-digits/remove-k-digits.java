class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st= new Stack<>();
        for(char  ch : num.toCharArray())
        {
            int n=ch-'0';
            while(!st.isEmpty() && k>0 && n<st.peek()){
            st.pop();
            k--;
            }

            st.push(n);
        }
        while(k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder sb= new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        String s=sb.reverse().toString().replaceFirst("^0+","");

        if(s.isEmpty())
        return "0";
        return s;
        
    }
}