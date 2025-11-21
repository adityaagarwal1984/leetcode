class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // MAX HEAP (no Comparable needed)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]        // sort by freq descending
        );

        for (Map.Entry<Integer,Integer> e : map.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
        }

        int[] ans = new int[k];
        int i = 0;

        while (i < k) {
            ans[i++] = pq.poll()[0];
        }

        return ans;
    }
}
