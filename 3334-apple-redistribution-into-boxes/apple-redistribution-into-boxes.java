class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int c=0;
        int a=0;
        for(int num:apple)
        a+=num;
        Arrays.sort(capacity);
        int i=capacity.length-1;
        while(i>=0)
        {
            if(a>0)
            {
                c++;
                a-=capacity[i];
            }
            else
            {
                break;
            }
            i--;
        }
        return c;
    }
}