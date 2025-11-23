class Solution {
    public int maxSumDivThree(int[] nums) {
        int total = 0;
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        for (int num : nums) {
            total += num;
            if (num % 3 == 1) r1.add(num);
            else if (num % 3 == 2) r2.add(num);
        }

        Collections.sort(r1);
        Collections.sort(r2);

        if (total % 3 == 0) return total;

        int ans = 0;

        if (total % 3 == 1) {
            int option1 = Integer.MAX_VALUE;
            int option2 = Integer.MAX_VALUE;

            if (!r1.isEmpty()) option1 = r1.get(0);                      
            if (r2.size() >= 2) option2 = r2.get(0) + r2.get(1);        

            ans = total - Math.min(option1, option2);
        }

        if (total % 3 == 2) {
            int option1 = Integer.MAX_VALUE;
            int option2 = Integer.MAX_VALUE;

            if (!r2.isEmpty()) option1 = r2.get(0);                      
            if (r1.size() >= 2) option2 = r1.get(0) + r1.get(1);         

            ans = total - Math.min(option1, option2);
        }

        return ans < 0 ? 0 : ans;
    }
}
