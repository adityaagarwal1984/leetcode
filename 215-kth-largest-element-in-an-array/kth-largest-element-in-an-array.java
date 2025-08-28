class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // int l= nums.length;
        // return nums[l-k];
    PriorityQueue<Integer> que= new PriorityQueue<>(Collections.reverseOrder());
    for(int num:nums)
    que.add(num);
    for(int i=0;i<k-1;i++)
    {
        que.poll();
    }
    return que.peek();

    
    }
}