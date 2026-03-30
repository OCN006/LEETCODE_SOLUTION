/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static int levels(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }
    public static void preOrder(TreeNode root ,List<Integer> ans ,int level){
        if(root==null) return ;
        ans.set(level,root.val);
        preOrder(root.left,ans,level+1);
        preOrder(root.right,ans,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        int n = levels(root);
        for(int i=0;i<n;i++){
            ans.add(0);
        }
        preOrder(root,ans,0);
        return ans ;
    }
}