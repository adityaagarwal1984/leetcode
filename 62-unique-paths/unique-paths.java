class Solution {
    public int uniquePaths(int m, int n) {
        
       
        int prev[]= new int[n];
        prev[0]=1;
        for(int i=0;i<m;i++)
        {
            int curr[]= new int[n];
            curr[0]=1;
            for(int j=1;j<n;j++)
            {
                
                int right=0;
                int down=0;
                if(j>0)
                 right=curr[j-1];
                if(i>0)
                 down=prev[j];
                curr[j]=right+down;
            }
            prev=curr;
        }
        return prev[n-1];
    }
}