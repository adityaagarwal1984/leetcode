class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st= new Stack<>();
         int n= arr.length;
         int left[]= new int[n];
         int right[]= new int [n];
         long mod= (long)1e9+7;
        
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
            st.pop();

            left[i]= st.isEmpty()?i+1:i-st.peek();
            st.push(i);
        }
        st.clear();

        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            st.pop();

            right[i]= st.isEmpty()?n-i:st.peek()-i;
            st.push(i);
        }
        long ans=0;
        for(int i=0;i<n;i++)
        {
            ans = (ans + (long) left[i] * right[i] * arr[i]) % mod;

        }
        return (int)ans;
        
        
    }
}