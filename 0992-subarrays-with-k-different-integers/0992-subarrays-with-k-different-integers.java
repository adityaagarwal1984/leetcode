class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int a= subarray(nums,k);
        int b=subarray(nums,k-1);
        return a-b;
        
    }
    public int subarray(int arr[],int k)
    {
        int left=0,right=0,c=0;int count=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        while(right<arr.length)
        {
            int num= arr[right];
            map.put(num,map.getOrDefault(num,0)+1);
            while(map.size()>k)
            {
                int n= arr[left];
                map.put(n,map.get(n)-1);
                if(map.get(n)==0)
                map.remove(n);
                left++;
            }

        
                count+=right-left+1;
                right++;
            
            

        }
        return count;
    }
}