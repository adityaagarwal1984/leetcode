class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int a : arr) {
            boolean destroyed = false;

            while (!st.isEmpty() && a < 0 && st.peek() > 0) {
                if (Math.abs(a) > st.peek()) {
                    st.pop(); // destroy smaller right asteroid
                    continue;
                } else if (Math.abs(a) == st.peek()) {
                    st.pop(); // both destroyed
                    destroyed = true;
                    break;
                } else {
                    destroyed = true; // current one destroyed
                    break;
                }
            }

            if (!destroyed) {
                st.push(a);
            }
        }

        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}
