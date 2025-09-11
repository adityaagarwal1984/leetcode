class Solution {
    public String sortVowels(String s) {
        int l= s.length();
        char a[]= new char[l];
        List<Character> list= new ArrayList<>();
        for(int i=0;i<l;i++)
        {
            char ch=s.charAt(i);
            if(ch=='A'|| ch=='E'|| ch=='I'|| ch=='O'|| ch=='U'||ch=='a'|| ch=='e'|| ch=='i'|| ch=='o' || ch=='u')
            list.add(ch);
            else
            a[i]=ch;
        }
        Collections.sort(list);
        int j=0;
        for(int i=0;i<l;i++)
        {
            if(a[i]=='\u0000')
            {
            a[i]=list.get(j);
            j++;
            }

        }
        return new String(a);
        
    }
}