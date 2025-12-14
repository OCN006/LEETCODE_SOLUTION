class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;

        int totalSeats = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') totalSeats++;
        }

        // must have even number of seats
        if (totalSeats == 0 || totalSeats % 2 != 0) return 0;

        long ways = 1;
        int seatsSeen = 0;
        int plantsBetween = 0;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatsSeen++;

                // when starting a NEW pair (except first), multiply
                if (seatsSeen > 2 && seatsSeen % 2 == 1) {
                    ways = (ways * (plantsBetween + 1)) % MOD;
                    plantsBetween = 0;
                }
            } else {
                // count plants only between completed seat pairs
                if (seatsSeen % 2 == 0 && seatsSeen > 0) {
                    plantsBetween++;
                }
            }
        }

        return (int) ways;
    }
}
