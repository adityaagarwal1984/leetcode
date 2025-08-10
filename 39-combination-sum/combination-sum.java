class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> slist= new ArrayList<>();
        solve(candidates,target,list,slist,candidates.length-1);
        return list;
        
    }
    public void solve(int arr[],int tar,List<List<Integer>> list,List<Integer>slist,int i)
    {
        //base condition
        if(tar==0){
        list.add(new ArrayList<>(slist));
        return;
        }
        if (i == 0) {
            if (tar % arr[0] == 0) { // can we form target using arr[0] repeatedly?
                int count = tar / arr[0];
                for (int k = 0; k < count; k++) {
                    slist.add(arr[0]);
                }
                list.add(new ArrayList<>(slist));
                for (int k = 0; k < count; k++) {
                    slist.remove(slist.size() - 1); // backtrack
                }
            }
            return;
        }

        if(arr[i]<=tar)
        {
            slist.add(arr[i]);
            solve(arr, tar-arr[i],list,slist, i);
            slist.remove(slist.size() - 1);

        }
        solve(arr, tar,list,slist, i-1);
    }
}