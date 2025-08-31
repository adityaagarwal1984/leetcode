class KthLargest {

List<Integer> list;
int k;
    public KthLargest(int k, int[] nums) {
        list= new ArrayList<>();
        for(int num:nums)
        {
            list.add(num);
        }
        this.k=k;
        
        
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size()-k);
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */