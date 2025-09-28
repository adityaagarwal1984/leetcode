class Solution {
    public int largestPerimeter(int[] nums) { 
  Integer[] num = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(num, (a, b) -> b - a);
    for(int i=0;i<num.length-2;i++)
    {
        int a=num[i];
        int b= num[i+1];
        int c= num[i+2];
        if(a+b>c && b+c>a && c+a>b)
        return a+b+c;

    }
    return 0;

        
    }
}