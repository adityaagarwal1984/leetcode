class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int first=search(nums,target,true);
        int last=search(nums,target,false);
        return new int[]{first,last};
    }
    public int search(int arr[],int tar,boolean first )
    {
        int lb=0;
        int ub=arr.length-1;
        int ans=-1;
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;
            if(arr[mid]==tar)
            {
                if(first)
                {
                    ans=mid;
                    ub=mid-1;
                }
                else
                {
                    ans=mid;
                    lb=mid+1;
                }

            }
            else if(arr[mid]<tar)
            lb=mid+1;
        else
        ub=mid-1;
        }
return ans;
    }
}