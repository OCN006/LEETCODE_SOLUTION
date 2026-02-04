class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // js sort them both 
        // and we can match them
        Arrays.sort(s);
        Arrays.sort(g);
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            // if we find that both of em satisfies means it's the best 
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            }
            // if g is greater move j 
            else {
                j++;
            }
        }

        return count;
    }
}