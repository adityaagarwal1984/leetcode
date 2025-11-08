class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[]={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ans= new ArrayList<>();
        comb(arr,n,k,new ArrayList<>(),ans,0);
        return ans;

    }
    public void comb(int arr[],int tar,int size,List<Integer> list,List<List<Integer>> ans,int i)
    {
        if(list.size()==size)
        {
            if(tar==0){
            ans.add(new ArrayList<>(list));
            
            }
            return;
        }
        if(i==arr.length || tar<0)
        return;
        if(arr[i]<=tar)
        {
            list.add(arr[i]);
            comb(arr,tar-arr[i],size,list,ans,i+1);
            list.remove(list.size()-1);
        }
        comb(arr,tar,size,list,ans,i+1);
    }
}