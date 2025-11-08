class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

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
    if(arr[i]<=tar){

    list.add(arr[i]);

    solve(arr,tar-arr[i],list,ans,i+1);

    list.remove(list.get(list.size()-1));
    }
    int idx=i+1;
    while(idx<arr.length && arr[i]==arr[idx])
    idx++;
    
    
    solve(arr,tar,list,ans,idx);

}
}