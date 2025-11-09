class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[]= new int[nums1.length];
        int nge[]= nge(nums2);
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                if(nums1[i]==nums2[j])
                {
                    ans[i]=nge[j];
                }
            }
        }
        return ans;
        
    }
    public int[] nge(int arr[])
    {
        int ans[]=new int[ arr.length];
        int n= arr.length;
        Stack<Integer> st= new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=arr[i])
            {
                st.pop();
            }
            ans[i]=st.isEmpty()?-1:st.peek();
            st.push(arr[i]);
        }
        return ans;
    }
}