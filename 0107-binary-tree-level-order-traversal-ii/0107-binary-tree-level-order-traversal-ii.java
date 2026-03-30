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
        return 1+Math.max(levels(root.left),levels(root.right));
    }
    public static void nTHLevel(TreeNode root , List<Integer> ans , int i , int x){
        if(root==null) return ;
        if(i==x) ans.add(root.val);
        nTHLevel(root.left,ans,i,x+1);
        nTHLevel(root.right,ans,i,x+1);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       List<List<Integer>> list = new ArrayList<>();
       int n = levels(root);
       for(int i=n-1;i>=0;i--){
        List<Integer> ans = new ArrayList<>();
        nTHLevel(root,ans,i,0);
        list.add(ans);
       }
       return list;
    }
}