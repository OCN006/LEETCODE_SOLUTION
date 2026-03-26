/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean exists(TreeNode root,TreeNode Node){
        if(root==null) return false;
        if(root.val==Node.val) return true;
        return exists(root.left,Node)||exists(root.right,Node);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val == root.val||q.val==root.val) return root;
        boolean pInLST = exists(root.left,p);
        boolean qInLST = exists(root.left,q);
        if(pInLST&&!qInLST) return root;
        if(!pInLST&&qInLST) return root;
        if(pInLST&&qInLST) return lowestCommonAncestor( root.left,  p,  q);
        if(!pInLST&&!qInLST) return lowestCommonAncestor( root.right,  p,  q);
        return null;
        
    }
}