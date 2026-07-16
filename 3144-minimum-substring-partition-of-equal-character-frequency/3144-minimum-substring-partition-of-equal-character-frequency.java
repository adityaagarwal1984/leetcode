class Solution {
    public int minimumSubstringsInPartition(String s) {
        int arr[]= new int[s.length()+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=s.length();i++)
        {
            String curr="";
            int min= Integer.MAX_VALUE;
            HashMap<Character,Integer> map= new HashMap<>();
            for(int j=i;j>0;j--)
            {
                //curr= s.charAt(j-1)+curr;
                map.put(s.charAt(j-1),map.getOrDefault(s.charAt(j-1),0)+1);
                boolean check= true;
               List<Integer> ls= new ArrayList<>();
                for(int num: map.values())
                {
                    if(ls.size()>0)
                    {
                        if(ls.get(ls.size()-1)!=num)
                        {
                            check= false;
                            break;
                        }
                        
                    }
                    ls.add(num);

                }
                if(check==false)
                continue;
                min = Math.min(min,1+ arr[j-1]);
            }
            arr[i]= min;
        }
        return arr[s.length()];
    }
    // public boolean check_freq(String s)
    // {
    //     Map<Character,Integer> map= new HashMap<>();
    //     for(char ch: s.toCharArray())
    //     {
    //         map.put(ch,map.getOrDefault(ch,0)+1);
    //     }
    //     List<Integer> ls= new ArrayList<>();
    //     for(int num: map.values())
    //     {
    //         if(ls.size()>0)
    //         {
    //             if(ls.get(ls.size()-1)!=num)
    //             return false;
    //         }
    //         ls.add(num);

    //     }
    //     return true;

    // }
    
}