class Solution {
    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        // Base case: null node
        if (root == null) return false;

        // If complement is found, return true
        if (set.contains(k - root.val)) return true;

        // Otherwise, add current node value to the set
        set.add(root.val);

        // Recurse on left and right subtrees
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}