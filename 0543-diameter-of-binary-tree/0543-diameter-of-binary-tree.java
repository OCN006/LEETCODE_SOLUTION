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
        int LST = levels(root.left);
        int RST = levels(root.right);
        int dia = LST+RST;
        maxDia=Math.max(dia,maxDia);
        return 1+Math.max(LST,RST);
    }
    public int diameterOfBinaryTree(TreeNode root) {
         if(root==null) return 0;
        levels(root);
        return maxDia;
    }
}