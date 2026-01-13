class Solution {
 
    Map<String, Boolean> mp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();

       
        if (s2.length() != n)
            return false;

      
        if (s1.equals(s2))
            return true;

       
        if (n == 1)
            return false;

        String key = s1 + " " + s2;

        if (mp.containsKey(key))
            return mp.get(key);

        
        for (int i = 1; i < n; i++) {
            
            boolean withoutswap = (
                    // left part of first and second string
                    isScramble(s1.substring(0, i), s2.substring(0, i))

                            &&

                            // right part of first and second string;
                            isScramble(s1.substring(i), s2.substring(i))
            );

            // if without swap give us right answer then we do not need
            // to call the recursion withswap
            if (withoutswap) {
                mp.put(key, true);
                return true;
            }

            // ex of withswap: gr|eat rge|at
            // here we compare "gr" with "at" and "eat" with "rge"
            boolean withswap = (
                    // left part of first and right part of second
                    isScramble(s1.substring(0, i), s2.substring(n - i))

                            &&

                            // right part of first and left part of second
                            isScramble(s1.substring(i), s2.substring(0, n - i))
            );

            // if withswap give us right answer then we return true
            // otherwise the for loop do it work
            if (withswap) {
                mp.put(key, true);
                return true;
            }
            // we are not returning false in else case
            // because we want to check further cases with the for loop
        }
        mp.put(key, false);
        return false;
    }
}