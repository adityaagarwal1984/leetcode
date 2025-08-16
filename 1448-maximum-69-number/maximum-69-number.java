class Solution {
    public int maximum69Number (int num) {
        String st= Integer.toString(num);
        int c=0;
        StringBuilder sb=  new StringBuilder();
        for(int i=0;i<st.length();i++)
        {
            char ch= st.charAt(i);
            if(ch=='6' && c==0)
            {
                ch='9';
                c=1;
                sb.append(ch);
            }
            else
            sb.append(ch);
        }
        String s= sb.toString();
        return Integer.parseInt(s);
        
    }
}