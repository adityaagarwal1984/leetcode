class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st= new Stack<>();
        int l= expression.length();
        for(int i=0;i<l;i++)
        {
            if(expression.charAt(i)==',')
            continue;
            if(expression.charAt(i)==')')
            {
                List<Character> list= new ArrayList<>();
                while(st.peek()!='(')
                list.add(st.pop());
                st.pop();
                char opr=st.pop();
                if(opr=='&')
                {
                    boolean fal=false;
                    for(char ch:list)
                    {
                        if(ch=='f')
                        {
                            fal =true;
                            break;
                        }

                    }
                    if(fal==true)
                    st.push('f');
                    else
                    st.push('t');
                }
                if(opr=='|')
                {
                    boolean fal=false;
                    for(char ch:list)
                    {
                        if(ch=='t')
                        {
                            fal =true;
                            break;
                        }

                    }
                    if(fal==true)
                    st.push('t');
                    else
                    st.push('f');
                }
                if(opr=='!')
                {
                    if(list.get(0)=='t')
                    st.push('f');
                    else
                    st.push('t');
                }
            }
            else
            st.push(expression.charAt(i));
        }
        if(st.peek()=='f')
        return false;
        else
        return true;
    }
}