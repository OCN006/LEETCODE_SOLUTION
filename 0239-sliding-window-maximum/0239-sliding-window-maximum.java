class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        int i = 0;
        int j = 0;
        int index = 0;
        
        while (j < n) {
            
            // Remove elements smaller than current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
                deque.pollLast();
            }
            
            // Add current index
            deque.offerLast(j);
            
            // Remove elements outside the window
            if (deque.peekFirst() < i) {
                deque.pollFirst();
            }
            
            // Window size is k
            if (j - i + 1 == k) {
                
                // Front always contains index of maximum
                ans[index++] = nums[deque.peekFirst()];
                
                // Move window
                i++;
            }
            
            j++;
        }
        
        return ans;
    }
}