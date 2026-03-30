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

    public static void levelOrder(int i , List<Integer> list , TreeNode root,int x){
        if(root==null) return ;
        if(i==x) list.add(root.val);
        levelOrder(i,list,root.left,x+1);
        levelOrder(i,list,root.right,x+1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int lvl = levels(root);
        for(int i=0;i<lvl;i++){
            List<Integer> list = new ArrayList<>();
            levelOrder(i,list,root,0);
            ans.add(list);
        }
        return ans;
    }
}