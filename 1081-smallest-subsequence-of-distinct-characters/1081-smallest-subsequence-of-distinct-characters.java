import java.util.Stack;

class Solution {
    public String smallestSubsequence(String s) {
        // 1. Count the total occurrences of each character
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        // 2. Track if a character is already included in our result stack
        boolean[] visited = new boolean[26];
        
        // Using StringBuilder as a stack so we can easily convert to string at the end
        StringBuilder stack = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            count[curr - 'a']--; // We've processed this instance
            
            // If it's already in our result, skip it (we only want exactly once)
            if (visited[curr - 'a']) {
                continue;
            }
            
            // Monotonic Stack logic:
            // While the stack is not empty, and the top of the stack is lexicographically 
            // larger than current character, AND that top character appears again later:
            while (stack.length() > 0 && 
                   stack.charAt(stack.length() - 1) > curr && 
                   count[stack.charAt(stack.length() - 1) - 'a'] > 0) {
                
                // Pop it out and mark it as not visited
                char removed = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                visited[removed - 'a'] = false;
            }
            
            // Push current character to stack and mark visited
            stack.append(curr);
            visited[curr - 'a'] = true;
        }
        
        return stack.toString();
    }
}