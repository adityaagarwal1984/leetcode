class Solution {
static int parent[];
static int rank[];
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans=new ArrayList<>();
         parent= new int[accounts.size()];
         rank=new int[accounts.size()];
        int n=accounts.size();
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            ans.add(new ArrayList<>());
        }
        Map<String,Integer> map= new HashMap<>();
        int users=0;
        for(List<String> st:accounts)
        {
            for(int i=1;i<st.size();i++)
            {
                String mail=st.get(i);
                if(map.containsKey(mail))
                {
                    int u=map.get(mail);
                    union(u,users);
                   
                }
                else
                {
                    map.put(mail,users);
                }
            }
            users++;
        }
        for(Map.Entry<String,Integer> it:map.entrySet())
        {
            String mail=it.getKey();
            int user=it.getValue();
            int ulp=find(user);
            String username=accounts.get(ulp).get(0);
            if(ans.get(ulp).size()==0)
            {
                ans.get(ulp).add(username);
                ans.get(ulp).add(mail);
            }
            else
            {
                 ans.get(ulp).add(mail);
            }
        }
        ans.removeIf(ls -> ls.isEmpty());

for (List<String> ls : ans) {
    if (ls.size() > 2) {
        Collections.sort(ls.subList(1, ls.size()));
    }
}


        return ans;

    }
    public int find(int u)
    {
        if(u==parent[u])
        return u;
        int p=find(parent[u]);
        parent[u]=p;
        return parent[u];
    }
    public void union(int u,int v)
    {
        int pu=find(u);
        int pv=find(v);
        if(pu==pv)
        return;
        if(rank[pu]<rank[pv])
        {
            parent[pu]=pv;
        }
        else if(rank[pv]<rank[pu])
        {
            parent[pv]=pu;
        }
        else
        {
            parent[pv]=pu;
            int ranku=rank[pu];
            rank[pu]++;
        }
    }
}