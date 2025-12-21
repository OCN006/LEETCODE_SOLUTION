class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        
        boolean[] sorted = new boolean[n - 1];
        int deletions = 0;

        for (int col = 0; col < m; col++) {
            boolean bad = false;

            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i] && strs[i].charAt(col) > strs[i + 1].charAt(col)) {
                    bad = true;
                    break;
                }
            }

            if (bad) {
                deletions++;
                continue;
            }

            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i] && strs[i].charAt(col) < strs[i + 1].charAt(col)) {
                    sorted[i] = true;
                }
            }
        }
        return deletions;
    }
}
