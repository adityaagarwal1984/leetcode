class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        return false;

        else
        return sort(s).equals(sort(t));

        
    }
    public String sort(String s)
    {
        char arr[]= s.toCharArray();
        Arrays.sort(arr);
        return Arrays.toString(arr);
    }
}