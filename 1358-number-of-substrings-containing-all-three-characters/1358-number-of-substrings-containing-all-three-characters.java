class Solution {
    public int numberOfSubstrings(String s) {
           int n = s.length();
 
        // At least three characters are required.
        if (n < 3) {
            return 0;
        }
 
        int[] frequency = new int[3];
 
        int left = 0;
        long count = 0;
 
        // Expand the window by moving the right boundary.
        for (int right = 0; right < n; right++) {
            frequency[s.charAt(right) - 'a']++;
 
            // Shrink while the current window contains all three characters.
            while (
                frequency[0] > 0 &&
                frequency[1] > 0 &&
                frequency[2] > 0
            ) {
                // Every later ending gives another valid substring.
                count += n - right;
 
                frequency[s.charAt(left) - 'a']--;
                left++;
            }
        }
 
        return (int)count;
    
    }
}