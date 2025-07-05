class Solution {
    public int findLucky(int[] arr) {
        int max=-1;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num: arr)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> hash: map.entrySet())
        {
            if(hash.getKey()==hash.getValue())
            max=Math.max(max,hash.getKey());
        }
        
        return max;
    }
}