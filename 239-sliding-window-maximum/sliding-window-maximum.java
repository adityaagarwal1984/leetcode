class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // int arr[]= new int[nums.length-k+1];
        
        // int i=0;
        // int j= nums.length-k;
        // while(i<=j)
        // {
        //     int max= Integer.MIN_VALUE;
        //     for(int z=i;z<i+k;z++)
        //     {
        //         max=Math.max(max,nums[z]);
        //     }
        //     arr[i]=max;
        //     i++;

        // }    
        // return arr;    
         
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1]; // Output array
        Deque<Integer> deque = new LinkedList<>(); // Store indices of elements

        // Step 1: Process first k elements
        for (int i = 0; i < k; i++) {
            // Remove elements smaller than current from rear
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i); // Add current index
        }

        // Step 2: Process the rest of the elements (from k to n-1)
        for (int i = k; i < n; i++) {
            // Front of deque is max for previous window
            result[i - k] = nums[deque.peekFirst()];

            // Remove indices that are out of this window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove all smaller elements as they are useless now
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);
        }

        // Add max of last window
        result[n - k] = nums[deque.peekFirst()];

        return result;
    

    }
}