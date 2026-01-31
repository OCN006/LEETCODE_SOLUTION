class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n) 
        {
            return -1;
        }

        int low = 1;
        int high = 0;
        int ans = -1;
        
        for (int i = 0; i < n; i++) {
         
            high = Math.max(high, bloomDay[i]);
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (helper(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.gc();
        return ans;
    }

    public static boolean helper(int bloomDay[], int mid, int bouquet, int adjacent) {
        int flowers = 0;
        int bt = 0;
        for (int bloom : bloomDay) 
        {
            if (bloom <= mid)
             {
                flowers++;
                if (flowers == adjacent)
                 {
                    bt++;
                    flowers = 0;
                }
            } 
            else 
            {
                flowers = 0;
            }
        }
        return bt >= bouquet;
    }
}