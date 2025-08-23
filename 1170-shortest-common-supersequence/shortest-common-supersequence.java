class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m=str1.length();
        int n= str2.length();
        int arr[][]= new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            arr[i][0]=0;
        }
        for(int j=1;j<=n;j++)
        {
            arr[0][j]=0;
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    arr[i][j]=1+arr[i-1][j-1];

                }
                else
                {
                    arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
                }

            }
        }
        StringBuilder sb= new StringBuilder();
        int i=m, j=n;
        while(i>0 && j>0)

        {
            if(str1.charAt(i-1)==str2.charAt(j-1))
            {
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(arr[i][j-1]>arr[i-1][j])
            {
                sb.append(str2.charAt(j-1));
                j--;
            }
            else
            {
                sb.append(str1.charAt(i-1));
                i--;
            }
        }
        while(i>0)
        {
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0)
        {
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
}