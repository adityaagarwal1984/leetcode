import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        // Step 1: Extract unique elements from nums
        boolean[] present = new boolean[2048];
        int uniqueCount = 0;
        for (int num : nums) {
            if (!present[num]) {
                present[num] = true;
                uniqueCount++;
            }
        }
        
        int[] U = new int[uniqueCount];
        int idx = 0;
        for (int i = 0; i < 2048; i++) {
            if (present[i]) {
                U[idx++] = i;
            }
        }

        // Step 2: Find all unique pair XOR values (at most 2048 possible values)
        boolean[] pairXorSet = new boolean[2048];
        for (int i = 0; i < U.length; i++) {
            for (int j = i; j < U.length; j++) {
                pairXorSet[U[i] ^ U[j]] = true;
            }
        }

        // Collect valid pair XORs into an array
        List<Integer> pairXors = new ArrayList<>();
        for (int i = 0; i < 2048; i++) {
            if (pairXorSet[i]) {
                pairXors.add(i);
            }
        }

        // Step 3: Compute all unique triplet XORs (pairXor ^ c)
        boolean[] tripletXorSet = new boolean[2048];
        for (int p : pairXors) {
            for (int c : U) {
                tripletXorSet[p ^ c] = true;
            }
        }

        // Count unique triplet XOR values
        int result = 0;
        for (boolean exists : tripletXorSet) {
            if (exists) result++;
        }

        return result;
    }
}