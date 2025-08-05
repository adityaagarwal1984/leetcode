class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int c=0;
        int n=fruits.length;
        int arr[]= new int[fruits.length];
        Arrays.fill(arr,0);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[j]!=-1 && fruits[i]<= baskets[j])
                {
                    arr[j]=-1;
                    c++;
                    break;
                }
            }
        }
        return n-c;
        
    }
}