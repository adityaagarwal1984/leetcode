class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int c=0;
        HashMap<Integer,TreeSet<Integer>> mapx= new HashMap<>();
        HashMap<Integer,TreeSet<Integer>> mapy= new HashMap<>();
        for(int i=1;i<=n;i++)
        {
            mapx.put(i,new TreeSet<>());
            mapy.put(i,new TreeSet<>());
        }
        for(int a[]:buildings)
        {
            int x=a[0];
            int y=a[1];
            mapx.get(y).add(x);
            mapy.get(x).add(y);
        }
        for(int a[]:buildings)
        {
            int x=a[0];
            int y=a[1];
            TreeSet<Integer> col=mapy.get(x);
            TreeSet<Integer> row=mapx.get(y);
             Integer left  = row.lower(x);
            Integer right = row.higher(x);
            Integer down  = col.lower(y);
            Integer up    = col.higher(y);

            if (left != null && right != null && down != null && up != null){
            c++;
        }
    
        
    }
    return c;
}
}