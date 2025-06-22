class Solution {
    public String reverseWords(String s) {
        String str="";
        s=s.trim();
    String arr[]= s.split("\\s+");
    for(int i=arr.length-1;i>=0;i--)
    {
        if(i==0)
        str+=arr[i];
        else
        str+=arr[i]+" ";
    }
        return str;
    }
}