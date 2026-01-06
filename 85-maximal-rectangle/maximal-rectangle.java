class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int arr[][]= new int[m][n];
        for(int i=0;i<n;i++)
        {
            int s=0;
            for(int j=0;j<m;j++)
            {
                if(matrix[j][i]=='0')
                {
                    s=0;
                }
                else
                {
                s++;
                }
                arr[j][i]=s;

            }
        }
        int max=0;
        for(int a[]:arr)
        {
            int ans=maxarea(a);
            max=Math.max(max,ans);
        }
        return max;
    }
    public int maxarea(int arr[])
    {
        if(arr.length==0)
        return 0;
        if(arr.length<2)
        return arr[0];
        int pse[]=pse(arr);
        int nse[]=nse(arr);
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            int ns=nse[i];
            int ps=pse[i];
            int dis=ns-ps-1;
            max=Math.max(max,dis*arr[i]);
        }
        return max;
    }
    public int[] pse(int arr[])
    {
        Stack<Integer> st= new Stack<>();
        int ans[]= new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            st.pop();

            ans[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] nse(int arr[])
    {
        Stack<Integer> st= new Stack<>();
        int ans[]= new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            st.pop();

            ans[i]=st.isEmpty()?arr.length:st.peek();
            st.push(i);
        }
        return ans;
    }
}