class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>  list = new ArrayList<>();
        int l1=s.length();
        int l2= p.length();
        if(l2>l1)
        return list;
        int a[]=new int[26];
        int b[]= new int [26];
        for(char c:p.toCharArray()) // making an array to store string p 
        {
            a[c-'a']++;
        }
        for(int i=0;i<p.length();i++)
        {
            b[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(a,b))
        list.add(0);

        for(int j=l2;j<l1;j++)
        {
            b[s.charAt(j)-'a']++;
            b[s.charAt(j-l2)-'a']--;

            if(Arrays.equals(a,b))
            list.add(j-l2+1);
        }
        return list;

       }
}
