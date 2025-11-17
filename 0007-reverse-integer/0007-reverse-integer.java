class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        int res = 0;
        while (x > 0) {
            int digit = x % 10;
            x /= 10;
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }
            res = (res * 10) + digit;
        }

        return isNegative ? -res : res;        
    }
}