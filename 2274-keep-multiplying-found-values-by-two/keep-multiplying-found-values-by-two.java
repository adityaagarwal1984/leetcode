class Solution {
    public int findFinalValue(int[] nums, int original) {
        while(present(nums,original))
        {
            original*=2;
        }
        return original;
    }
    public boolean present(int arr[],int num)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==num)
            return true;
        }
        return false;
    }

}