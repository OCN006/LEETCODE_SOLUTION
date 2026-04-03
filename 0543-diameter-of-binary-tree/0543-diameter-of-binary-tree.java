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
    int maxDia;
    public int levels(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(levels(root.left),levels(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
         if(root==null) return 0;
        int LST = levels(root.left);
        int RST = levels(root.right);
        int dia = LST+RST;
        maxDia=Math.max(dia,maxDia);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return maxDia;
    }
}