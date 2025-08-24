class Solution {
    public int minDistance(String word1, String word2) {
        int arr[][]= new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++)
        {
            Arrays.fill(arr[i],-1);
        }
        return match(word1,word2,word1.length()-1,word2.length()-1,arr);
    }
    public int match(String s1,String s2,int i,int j,int arr[][])
    {
        if(j<0)
        return i+1;
        if(i<0)
        return j+1;
        if(arr[i][j]!=-1)
        return arr[i][j];

        if(s1.charAt(i)== s2.charAt(j))
         return arr[i][j]= match(s1,s2,i-1,j-1,arr);
         else
         {
            int insert=match(s1,s2,i,j-1,arr);
            int delete=match(s1,s2,i-1,j,arr);
            int replace=match(s1,s2,i-1,j-1,arr);
            return arr[i][j]= 1+Math.min(insert,Math.min(delete,replace));
         }
    }
}