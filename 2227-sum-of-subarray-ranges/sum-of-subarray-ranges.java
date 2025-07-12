class Solution {
    public long subArrayRanges(int[] arr) {
        // long sum=0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     int min=nums[i];
        //     int max=nums[i];

        //     for(int j=i;j<nums.length;j++)
        //     {
        //         max=Math.max(max,nums[j]);
        //         min=Math.min(min,nums[j]);
        //         sum+=max-min;
        //     }
        // }
        // return sum;


        //trying 0(n) solution by my own 
        // remeber taking in nse or nge use equals aslo in condition for handling edge cases.
        
        Stack<Integer> st= new Stack<>();
         int n= arr.length;
         int pse[]= new int[n];
         int nse[]= new int [n];
         int pge[]= new int[n];
         int nge[]= new int [n];
         long mod= (long)1e9+7;
        
        for(int i=0;i<n;i++) //pse
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
            st.pop();

            pse[i]= st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();

        for(int i=n-1;i>=0;i--) //nse
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            st.pop();

            nse[i]= st.isEmpty()?n:st.peek();
            st.push(i);
        }
        st.clear();
         for(int i=0;i<n;i++) //pge
        {
            while(!st.isEmpty() && arr[st.peek()]<arr[i])
            st.pop();

            pge[i]= st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();

        for(int i=n-1;i>=0;i--) // nge
        {
            while(!st.isEmpty() && arr[st.peek()]<=arr[i])
            st.pop();

            nge[i]= st.isEmpty()?n:st.peek();
            st.push(i);
        }
        st.clear();
        long ans=0;
         long max=0;long min=0;
        for(int i=0;i<n;i++)
        {
            int lsmall=i-pse[i];
            int lbig=i-pge[i];
            int rsmall=nse[i]-i;
            int rbig=nge[i]-i;
           
            max+=(long)(lbig*rbig)*arr[i];
            min+=(long)(lsmall*rsmall)*arr[i];
            
            
        }
        return max-min;
        

    }
}