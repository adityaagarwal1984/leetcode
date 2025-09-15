import java.util.*;
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        StringTokenizer tk = new StringTokenizer(text);
        int count = 0;

        while (tk.hasMoreTokens()) {
            String word = tk.nextToken();
            boolean canType = true;

            for (char ch : brokenLetters.toCharArray()) {
                if (word.indexOf(ch) != -1) { // word contains a broken letter
                    canType = false;
                    break;
                }
            }

            if (canType) count++;
        }

        return count;
    }
}
