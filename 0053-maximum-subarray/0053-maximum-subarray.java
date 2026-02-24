class Solution {
    public int maxSubArray(int[] nums) {
       int maxSum = nums[0]; 
        int Sum = nums[0];  

        for (int i = 1; i < nums.length; i++) {
            Sum = Math.max(nums[i], Sum + nums[i]); 
            maxSum = Math.max(maxSum, Sum); 
        }

        return maxSum;
    }

        
    }
