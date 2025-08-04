class Solution {
    public int maxJump(int[] stones) {
        int max=0;
        for(int i=2;i<stones.length;i++)
        {
            max= Math.max(max,stones[i]-stones[i-2]);
        }
        return Math.max(max,stones[1]-stones[0]);
        
    }
}