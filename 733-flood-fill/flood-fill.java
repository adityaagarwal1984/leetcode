class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m= image.length;
        int n= image[0].length;
        
        int el=image[sr][sc];
        if(el==color)
        return image;
        dfs(image,el,color,sr,sc);
        return image;
        
    }
    public void dfs (int arr[][],int el,int color,int i,int j)
    {
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length ||arr[i][j]!=el)
        return; 
        arr[i][j]=color;
        dfs(arr,el,color,i+1,j);
       dfs(arr,el,color,i-1,j);
       dfs(arr,el,color,i,j+1);
        dfs(arr,el,color,i,j-1);
    }
}