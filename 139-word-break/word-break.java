class Node {
    Node list[] = new Node[26];
    boolean end;

    public boolean contains(char ch) {
        return list[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return list[ch - 'a'];
    }

    public void put(char ch, Node node) {
        list[ch - 'a'] = node;
    }

    public void setEnd() {
        end = true;
    }

    public boolean isEnd() {
        return end;
    }
}

class Solution {

    Node root = new Node();
    Boolean dp[];

    public boolean wordBreak(String s, List<String> wordDict) {

        // Build Trie
        for (String w : wordDict)
            insert(w);

        dp = new Boolean[s.length()];

        // Check the string
        return check(s, 0);
    }

    // Recursive DFS check with memo
    public boolean check(String s, int idx) {

        // If completed string → success
        if (idx == s.length()) return true;

        // memoization
        if (dp[idx] != null) return dp[idx];

        Node node = root;

        // Try all possible prefixes starting at idx
        for (int i = idx; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (!node.contains(ch))
                break;  // No need to continue, prefix not found

            node = node.get(ch);

            // If this prefix is a valid word → recurse on remaining string
            if (node.isEnd()) {
                if (check(s, i + 1))
                    return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }

    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.contains(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
}
