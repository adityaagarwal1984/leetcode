class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set= new HashSet<>();
        int l=0;int r=0;int max=0;
       while(r<s.length())
       {
        if(!set.contains(s.charAt(r))){
        set.add(s.charAt(r));
        r++;
        }
        else
        {
            while(set.contains(s.charAt(r)))
            {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            r++;
            
        }
max=Math.max(max,r-l);
       }
       return max;
    }
}