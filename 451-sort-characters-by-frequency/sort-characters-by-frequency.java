class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map= new HashMap<>();
        for(char ch:s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<int []> pq= new PriorityQueue<>(
            (a,b)->b[1]-a[1]

        );
        for(Map.Entry<Character,Integer> entry: map.entrySet())
        {
            pq.offer(new int[]{entry.getKey(),entry.getValue()});
        }
        StringBuilder sb= new StringBuilder();
        while(pq.size()>0)
        {
            char ch=(char)pq.peek()[0];
            int freq=pq.peek()[1];
            pq.poll();
            for(int i=0;i<freq;i++)
            {
                sb.append(ch);
            }
        }
        return sb.toString();
        
    }
}