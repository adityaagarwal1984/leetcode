class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        solve(candidates,target,new ArrayList<>(),ans,0);
        return ans;
        
    }
public void solve(int arr[],int tar,List<Integer> list,List<List<Integer>> ans,int i)
{
    if(i==arr.length)
    {
        if(tar==0)
        {
            ans.add(new ArrayList<>(list));
            
        }
        return;
    }
    if(arr[i]<=tar)
    {
         list.add(arr[i]);
         solve(arr,tar-arr[i],list,ans,i);
         list.remove(list.size()-1);
    }
         solve(arr,tar,list,ans,i+1);
    
}
}