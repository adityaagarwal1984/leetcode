class Solution {
    public int myAtoi(String s) {
        // Step 1: Remove leading whitespaces
        s = s.replaceAll("^\\s+", "");
        
        // Step 2: Return 0 if string is empty after removing spaces
        if (s.isEmpty()) return 0;
        
        // Step 3: Handle sign
        boolean neg = false;
        int i = 0;
        if (s.charAt(0) == '-') {
            neg = true;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }
        
        // Step 4: Convert digits
        long num = 0; // use long to handle overflow
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            
            // Handle overflow during conversion
            if (neg && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (!neg && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            
            i++;
        }
        
        // Step 5: Apply sign
        if (neg) num = -num;
        
        return (int) num;
    }
}
