class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list= new ArrayList<>();
       List<Integer> l = new ArrayList<>();
       List<Integer> s= new ArrayList<>();
       s.add(1);
        list.add(new ArrayList<>(s));
        if(numRows==1)
        return list;
     l.add(1);
     l.add(1);
     list.add( new ArrayList<>(l));
        for(int i=2;i<numRows;i++)
        {
             List<Integer> slist= new ArrayList<>();
             slist.add(1);
             for(int j=0;j<list.get(i-1).size()-1;j++)
             {
                int num= list.get(i-1).get(j)+list.get(i-1).get(j+1);
                slist.add(num);
             }
             slist.add(1);
             list.add( new ArrayList<>(slist));

        }
        return list;
    }
}