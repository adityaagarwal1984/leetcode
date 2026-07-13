class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ls = new ArrayList<>();
        String sample = "123456789";
        
        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();
        
        // Loop through all possible lengths of sequential numbers
        for (int len = minLen; len <= maxLen; len++) {
            // Slide a window of that length across "123456789"
            for (int start = 0; start <= 9 - len; start++) {
                String sub = sample.substring(start, start + len);
                int val = Integer.parseInt(sub);
                
                if (val >= low && val <= high) {
                    ls.add(val);
                }
            }
        }
        
        return ls;
    }
}