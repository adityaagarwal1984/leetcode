class Solution {
    public String makeFancyString(String s) {
        int c=1;

        StringBuilder sb= new StringBuilder();
        sb.append(s.charAt(0));
       for(int i=1;i<s.length();i++)
       {
        if(s.charAt(i)==s.charAt(i-1))
          c++;
          if(s.charAt(i)!= s.charAt(i-1))
          c=1;
          if(c<3)
          sb.append(s.charAt(i));
       }
       return sb.toString();
        
    }
}