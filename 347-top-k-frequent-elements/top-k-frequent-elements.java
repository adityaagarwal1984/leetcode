import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Convert entrySet into a list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort by frequency (value) in descending order
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        // Take top k keys
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }

        return ans;
    }
}
