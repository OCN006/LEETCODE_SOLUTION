class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;

        // gap before first meeting
        if (meetings[0][0] > 1) {
            count += meetings[0][0] - 1;
        }

        int prevEnd = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end   = meetings[i][1];

            if (start > prevEnd + 1) {
                count += start - prevEnd - 1;
            }

            prevEnd = Math.max(prevEnd, end);
        }

        // gap after last meeting
        if (prevEnd < days) {
            count += days - prevEnd;
        }

        return count;
    }
}
