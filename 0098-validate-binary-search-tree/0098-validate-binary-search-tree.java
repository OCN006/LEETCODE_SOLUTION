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
    public long maximum(TreeNode root){
        if(root==null) return Long.MIN_VALUE;
        return Math.max(root.val,Math.max(maximum(root.left),maximum(root.right)));
    }   
    public long minimum(TreeNode root){
        if(root==null) return Long.MAX_VALUE;
        return Math.min(root.val,Math.min(minimum(root.left),minimum(root.right)));
    }   
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.val<=maximum(root.left))  return false;
        if(root.val>=minimum(root.right)) return false;
        return isValidBST(root.left) && isValidBST(root.right) ;
    }
}