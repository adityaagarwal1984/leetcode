class Solution {
    public List<String> letterCombinations(String digits) {
        String arr[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans= new ArrayList<>();
        comb(digits,arr,ans,0,"");
        return ans;
        
    }
    public void comb(String st,String arr[],List<String> list,int i,String ans)
    {
        if(i==st.length()){
        list.add(ans);
        return;
        }
       
            String part=arr[st.charAt(i)-'0'];
            for(int k=0;k<part.length();k++)
            {
                comb(st,arr,list,i+1,ans+part.charAt(k));
            }
        

    }

}