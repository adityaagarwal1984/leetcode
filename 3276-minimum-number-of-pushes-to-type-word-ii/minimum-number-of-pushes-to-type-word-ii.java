class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> map= new HashMap<>();
        for(char ch : word.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Integer> ls= new ArrayList<>();
        
        for(int val: map.values())
        {
            ls.add(val);
        }
        Collections.sort(ls,Collections.reverseOrder());
        int ans=0;
        for(int i=0;i<ls.size();i++)
        {
            int push= (i/8)+1;
            ans+= push* ls.get(i);
        }
        return ans;

    }
}