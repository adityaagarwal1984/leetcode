class Solution {
    public String largestGoodInteger(String num) {
        if(num.length()<3)
        return "";
        int c=0;
        int max= Integer.MIN_VALUE;
        String s="";
        String st="";
        for(int i=1;i<num.length();i++)
        {
            char ch= num.charAt(i);
            if(ch==num.charAt(i-1))
            {
                c++;
            }
            else
            c=0;
            if(c==2)
            {
                if(i!=num.length()-1)
                 st= num.substring(i-2,i+1);
                else
                 st= num.substring(i-2);
                int n= Integer.parseInt(st);
                if(max<n)
                {
                max=n;
                s=st;
                }
            }
        }
return s;
        
    }
}