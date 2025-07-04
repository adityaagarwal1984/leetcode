class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1],b[1]));
        int c=1;
        int prevend=intervals[0][1];
        if(intervals.length==0)
        return 0;
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1],b[1]));

        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0] >=prevend)
            {
                c++;
                prevend=intervals[i][1];
            }
            
        }
        return intervals.length-c;
    }
}