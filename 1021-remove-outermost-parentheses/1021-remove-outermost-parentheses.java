class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (k > 0) sb.append(ch);
                k++;
            } else {
                k--;
                if (k > 0) sb.append(ch);
            }
        }

        return sb.toString();
    }
}