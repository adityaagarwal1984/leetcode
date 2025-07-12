class Solution {
    public int largestRectangleArea(int[] heights) {
        int max=Integer.MIN_VALUE;
        for(int num:heights)
        {
            max=Math.max(max,num);
        }
        Stack<Integer> st= new Stack<>();
        int n=heights.length;
        int nse[]=new int[n];
        int pse[]= new int[n];
        for(int i= n-1;i>=0;i--)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i] )
            st.pop();
            nse[i]= st.isEmpty()?n:st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && heights[st.peek()]>heights[i] )
            st.pop();
            pse[i]= st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        int total=0;
        for(int i=0;i<n;i++)
        {
            
            int ans= heights[i]*(nse[i]-pse[i]-1);
            max=Math.max(max,ans);
        }
        return max;
        
    }
}