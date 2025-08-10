class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1= text1.length();
        int l2=text2.length();
        int arr[][]= new int[l1][l2];
        for(int i=0;i<l1;i++)
        {
            Arrays.fill(arr[i],-1);
        }
        return check(text1,text2,l1-1,l2-1,arr);
        
    }
    public int check(String s1,String s2,int i1,int i2,int arr[][])
    {
        if(i1<0 || i2<0)
        return 0;
        if(arr[i1][i2]!=-1)
        return arr[i1][i2];
        if(s1.charAt(i1)==s2.charAt(i2))
        return arr[i1][i2]= 1+check(s1,s2,i1-1,i2-1,arr);
        return arr[i1][i2]=Math.max(check(s1,s2,i1-1,i2,arr),check(s1,s2,i1,i2-1,arr));
    }
}