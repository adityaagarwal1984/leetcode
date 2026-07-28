class Solution {
    public String smallestPalindrome(String s) {
        int arr[]=new int[26];
        for(char ch: s.toCharArray())
        {
            arr[ch-'a']++;
        }
        char ans[] = new char[s.length()];
        int k=0;
        int j= s.length()-1;
       // char odd=' ';
        for(int i=0;i<26;i++)
        {
            char ch= (char)(i+'a');
            
                while(arr[i]>1)
                {
                    ans[k]= ch;
                    ans[j]=ch;
                    k++;
                    j--;
                    arr[i]-=2;
                }
                if(arr[i]==1)
                {
                    ans[s.length()/2]=ch;
                }
            
        }
        StringBuilder sb= new StringBuilder();
        for(char ch: ans)
        {
            sb.append(ch);
        }
        return sb.toString();



    }
}