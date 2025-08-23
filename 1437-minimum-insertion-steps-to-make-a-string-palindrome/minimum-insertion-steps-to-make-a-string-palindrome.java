class Solution {
    public int minInsertions(String s) {
        int l= s.length();
        int ans=longestPalindromeSubseq( s);
        return l-ans;

        
    }
    public int longestPalindromeSubseq(String s) {
        // first figure out the longest comon subsequence
        StringBuilder sb= new StringBuilder();
        sb.append(s).reverse();
        String st= sb.toString();
        int m= s.length();
        int n=st.length();
        int arr[][]= new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(arr[i],-1);
        }
        return lcs(s,st,s.length()-1,st.length()-1,arr);
    
        
    }
    public int lcs(String s1,String s2,int i,int j,int arr[][])
    {
        if(i<0 || j<0)
        return 0;
        if(arr[i][j]!=-1)
        return arr[i][j];
        if(s1.charAt(i) ==s2.charAt(j))
        return arr[i][j]= 1+lcs(s1,s2,i-1,j-1,arr);
        return  arr[i][j]=Math.max(lcs(s1,s2,i-1,j,arr),lcs(s1,s2,i,j-1,arr));
    }
}