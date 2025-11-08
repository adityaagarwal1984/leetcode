class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> slist= new ArrayList<>();
        subset(list,slist,nums,0);
        return list;

    }
    public void subset(List<List<Integer>> ans,List<Integer> list,int arr[],int i)
    {
     
        if(i==arr.length){
        ans.add(new ArrayList<>(list));
        return;
        }
        list.add(arr[i]);
        subset(ans,list,arr,i+1);
        list.remove(list.get(list.size()-1));
        subset(ans,list,arr,i+1);

    }
}