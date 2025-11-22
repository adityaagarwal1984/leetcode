class Solution {
    public int leastInterval(char[] tasks, int n) {
        //formula = (maxfreq-1)*n+1+maxcount;
    
     HashMap<Character,Integer> map= new HashMap<>();
     for(char ch:tasks)
     {
        map.put(ch,map.getOrDefault(ch,0)+1);
     }
     int max=0;
     for(int a: map.values())
     {
        max=Math.max(max,a);
     }
     int c=0;
     for(Map.Entry<Character,Integer> entry: map.entrySet())
     {
        if(entry.getValue()==max)
        c++;
     }
        int total=(max-1)*(n+1)+c;
        return Math.max(total,tasks.length);

    }
}