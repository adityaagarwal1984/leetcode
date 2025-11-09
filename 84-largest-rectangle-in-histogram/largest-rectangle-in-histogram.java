class Solution {
    public int largestRectangleArea(int[] heights) {
        int pse[]= pse(heights);
        int nse[]= nse(heights);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++)
        {
        
            max=Math.max(max,(nse[i]-pse[i]-1)*heights[i]);
        }
        return max;
        
    }
    public int[] nse(int arr[])
    {
        int ans[]= new int[arr.length];
        Stack<Integer> st= new Stack<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            st.pop();
            ans[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] pse(int arr[])
    {
        int ans[]= new int[arr.length];
        Stack<Integer> st= new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            st.pop();
            ans[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return ans;
    }
}