import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int num : stones) {
            list.add(num);
        }

        while (list.size() > 1) {
            Collections.sort(list, Collections.reverseOrder()); // sort descending
            int x = list.get(0);
            int y = list.get(1);

            list.remove(0); // remove x
            list.remove(0); // remove y (now at index 0)

            if (x != y) {
                list.add(x - y); // push back difference
            }
        }

        return list.isEmpty() ? 0 : list.get(0);
    }
}
