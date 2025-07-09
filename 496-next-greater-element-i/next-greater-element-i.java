class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n= nums2.length;
        int nge[]= new int[n];
        Stack<Integer> st= new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
        while(!st.isEmpty() && st.peek() <= nums2[i])
        st.pop();
        nge[i]=st.isEmpty()?-1:st.peek();

        st.push(nums2[i]);
        
    }
    int l= nums1.length;
    int arr[]= new int[l];
    for(int i=0;i<l;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(nums1[i]==nums2[j])
            {
                arr[i]=nge[j];
            }
        }
    }
    return arr;

}
}