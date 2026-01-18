class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set= new HashSet<>();
        for(String st:wordDict)
        set.add(st);
        List<String> ans= new ArrayList<>();
        solve(set,ans,s,0,"");
        return ans;

    }
    public void solve(HashSet<String> set,List<String> ans,String s,int idx,String newst)
    {
        if(idx>=s.length())
        {
            ans.add(newst.trim());
            return;
        }
        String st="";
        for(int i=idx;i<s.length();i++)
        {
            st+=s.charAt(i);
            if(set.contains(st))
            {
                solve(set,ans,s,i+1,newst+st+" ");
            }
        }
    }
}