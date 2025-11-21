public class Number implements Comparable<Number>
{
    int ele;
    int freq;
    Number(int e,int f)
    {
        ele=e;
        freq=f;
    }
    @Override
    public int compareTo(Number that)
{
return that.freq-this.freq;
}
}


class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num:nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Number> pq= new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            Number n= new Number(entry.getKey(),entry.getValue());
            pq.offer(n);
        }
        int arr[]= new int[k];
        int i=0;
        while(i<k)
        {
            arr[i++]=pq.poll().ele;
        }
        return arr;
    }
}