class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
       // Step 1: Store (value, index) pairs
List<int[]> list = new ArrayList<>();
for (int i = 0; i < nums.length; i++) {
    list.add(new int[]{nums[i], i});
}

// Step 2: Sort descending by value
list.sort((a, b) -> b[0] - a[0]);

// Step 3: Take top k elements
List<int[]> topK = list.subList(0, k);

// Step 4: Sort topK by index to preserve order
topK.sort((a, b) -> a[1] - b[1]);

// Step 5: Extract values
int[] ans = new int[k];
for (int i = 0; i < k; i++) {
    ans[i] = topK.get(i)[0];
}
return ans;
    }
}