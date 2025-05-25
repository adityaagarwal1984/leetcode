class Solution {
    public String resultingString(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = stack.length();
            if (len > 0 && isConsecutive(stack.charAt(len - 1), c)) {
                stack.deleteCharAt(len - 1); // Remove top
            } else {
                stack.append(c);
            }
        }

        return stack.toString();
    }

    private boolean isConsecutive(char a, char b) {
        int diff = Math.abs(a - b);
        return diff == 1 || diff == 25;
    }
}
