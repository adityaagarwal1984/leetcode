class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);   // base for length calculation
        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                st.push(i);
            } else { // ')'
                st.pop();

                if (st.isEmpty()) {
                    // new invalid boundary
                    st.push(i);
                } else {
                    // valid substring ends here
                    max = Math.max(max, i - st.peek());
                }
            }
        }
        return max;
    }
}
