class Solution {
    public int numDistinct(String s, String t) {
        int arr[][]= new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++)
        {
            Arrays.fill(arr[i],-1);
        }

        return numberofseq(s,t,s.length()-1,t.length()-1,arr);
    }
    public int numberofseq(String s,String t,int i,int j ,int arr[][])
    {
        if( j<0)
        return 1;
        if(i<0)
        return 0;
        if(arr[i][j]!=-1)
        return arr[i][j];
        if(s.charAt(i)==t.charAt(j))
        {
            return  arr[i][j]=numberofseq(s,t,i-1,j-1,arr)+numberofseq(s,t,i-1,j,arr);
        }
        else
       return arr[i][j]= numberofseq(s,t,i-1,j,arr);

    }

}