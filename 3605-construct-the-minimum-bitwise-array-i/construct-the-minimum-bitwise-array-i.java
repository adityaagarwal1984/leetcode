class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int arr[]= new int[nums.size()];
        int i=0;
        
        for(int num:nums)
        {
            boolean done=false;
            for(int j=1;j<num;j++)
            {
                if((j|(j+1))==num)
                {
                    arr[i]=j;
                    i++;
                    done=true;
                    break;
                }
            }
            if(done==false)
            {
            arr[i]=-1;
            i++;
            }
        }
        return arr;
    }
}