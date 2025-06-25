class Solution {
    public int minBitFlips(int start, int goal) {
        int num=start^goal; // xor of two numbers.
        //counting of set bits 
        int c=0;
        while(num>0)
        {
           c+= num & 1;
            num=num>>1;
        }
        return c;

        
    }
}