class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {

        if (node == null)
            return 0;

        int left = Math.max(0, maxGain(node.left));
        int right = Math.max(0, maxGain(node.right));

        // Path passing through current node
        int currentPath = left + node.val + right;

        maxSum = Math.max(maxSum, currentPath);

        // Maximum path that can be extended to parent
        return node.val + Math.max(left, right);
    }
}