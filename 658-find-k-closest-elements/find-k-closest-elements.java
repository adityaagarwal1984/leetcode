import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();

        // Step 1: Find the closest index to x using binary search
        int index = findClosestIndex(arr, x);

        // Step 2: Use two pointers to expand
        int left = index;
        int right = index + 1;

        // Step 3: Collect k closest elements
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= n) {
                left--;
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left--;
            } else {
                right++;
            }
        }

        // Step 4: Add elements from left+1 to right-1 (both inclusive)
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    // Helper: find index of closest element to x
    private int findClosestIndex(int[] arr, int x) {
        int lb = 0, ub = arr.length - 1;
        while (lb < ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] < x) lb = mid + 1;
            else ub = mid;
        }
        // Handle case where x smaller/larger than all elements
        if (lb > 0 && Math.abs(arr[lb - 1] - x) <= Math.abs(arr[lb] - x)) {
            return lb - 1;
        }
        return lb;
    }
}
