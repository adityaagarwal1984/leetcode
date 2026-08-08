class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set= new HashSet<>();
        for(String st: deadends)
        {
            set.add(st);

        }
        if(set.contains("0000") ||  set.contains(target))
        {
            return -1;
        }
        Queue<String> que= new LinkedList<>();
       // Map<String,Boolean> map= new HashMap<>();
        que.offer("0000");
        //map.put("0000",true);
        int time=0;
        while(!que.isEmpty())
        {
        int l= que.size();
        for(int j=0;j<l;j++)
        {
          String curr= que.poll();
          if(curr.equals(target)) return time;
          for(int i=0;i<curr.length();i++)
          {
            char ch= curr.charAt(i);
            int val= ch-'0';
            int a= (val+1)%10;
            int b= (val-1+10)%10;
            char arr[]= curr.toCharArray();
            //char arrr[]= curr.toCharArray();
            String f="";
            String s="";
            arr[i]=(char)(a+'0');
            f= new String(arr);
            //if(f.equals(target)) return time+1;
            arr[i]=(char)(b+'0');
            s= new String(arr);
            //if(s.equals(target)) return time+1;
            if( !set.contains(f))
            {
               set.add(f);
                que.offer(f);
            }
            if(!set.contains(s))
            {
               // map.put(s,true);
                que.offer(s);
                set.add(s);
            }

          }
        }
        time++;
          
        }
  return -1;
    }
}