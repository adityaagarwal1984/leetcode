class Solution {

    // public int[] prefixmax(int arr[])
    // {
    //     int pre[]= new int [arr.length];
    //     pre[0]=arr[0];
    //     for(int i=1;i<arr.length;i++)
    //     {
    //         pre[i]=Math.max(pre[i-1],arr[i]);
    //     }
    //     return pre;
    // }
    // public int[] suffixmax(int arr[])
    // {
    //     int suf[]= new int[ arr.length];
    //     suf[arr.length-1]=arr[arr.length-1];
    //     for(int j=arr.length-2;j>=0;j--)
    //     {
    //         suf[j]=Math.max(suf[j+1],arr[j]);
    //     }
    //     return suf;
    // }
    public int trap(int[] height) {
        // if(height.length==0)
        // return 0;
        // int prefixmax[]=prefixmax(height);
        // int suffixmax[]=suffixmax(height);
        // int total=0;
        // for(int i=0;i<height.length;i++)
        // {
        //     if(height[i]<prefixmax[i] && height[i]<suffixmax[i])
        //     {
        //         total+=Math.min(prefixmax[i],suffixmax[i])-height[i];
        //     }
        // }
        // return total;
        int total=0;
        int l=0;int r=height.length-1;
        int lmax=0,rmax=0;
        while(l<r)
        {
            if(height[l]<=height[r])
            {
                if(lmax> height[l])
                total+= lmax-height[l];
                else
                lmax=height[l];
                l++;
            }
            else
            {
                if(rmax> height[r])
                total+= rmax-height[r];
                else
                rmax=height[r];
                r--;

            }
        }
        return total;
        
    }
}