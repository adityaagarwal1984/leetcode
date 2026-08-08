// class pair{
//     String name;
//     int times;
//     pair(String s ,int t)
//     {
//         name=s;
//         times=t;
//     }
// } 
 class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set= new HashSet<>();
        for(String name:wordList)

        {
            set.add(name);
        }
        if(!set.contains(endWord))
        return 0;
        int step=1;
        Queue<String> que= new LinkedList<>();
        que.offer(beginWord);
        set.remove(beginWord);
        while(!que.isEmpty())
        {
           // pair p=que.poll();
           int l= que.size();
           for(int q=0;q<l;q++)
           {
            String st= que.poll();
            if(st.equals(endWord)) return step;
            //int step=p.times;
            for(int i=0;i<st.length();i++)
            {
                char newst[]=st.toCharArray();
                for(int j=97;j<=122;j++)
                {
                    char ch=(char)j;
                    if(newst[i]==ch)
                    continue;
                   
                    newst[i]=ch;
                    String newstr=new String(newst);
                     if(newstr.equals(endWord))
                    return step+1;
                    if(set.contains(newstr))
                    {
                        que.offer(newstr);
                        set.remove(newstr);
                    }
                   

                }
            }
           }
            step++;
        }
        return 0;

        
    }
}