class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
       int arr[][]= new int[row][col];
       int ans=0;
       for(int a[]:cells)
       {
        int i=a[0];
        int j=a[1];
        arr[i-1][j-1]=1;
        if(isPathExists(arr)==true)
        ans++;
        else
        break;
       }
       return ans;

    }
    public boolean isPathExists(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
    for (int j = 0; j < grid[0].length; j++) {
        if (grid[0][j] == 0) {
            if (path(grid,vis, 0, j))
                return true;
        }
    }
    return false;
}

   public boolean path(int[][] arr, boolean vis[][],int i, int j) {

    // boundary check
    if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length)
        return false;

    // water or already visited
    if (arr[i][j] == 1 || vis[i][j])
        return false;

    // reached last row
    if (i == arr.length - 1)
        return true;

    // mark visited
    vis[i][j]=true;

    boolean ans =
        path(arr,vis, i + 1, j) ||
        path(arr, vis,i - 1, j) ||
        path(arr, vis,i, j + 1) ||
        path(arr, vis,i, j - 1);

    return ans;
}

}