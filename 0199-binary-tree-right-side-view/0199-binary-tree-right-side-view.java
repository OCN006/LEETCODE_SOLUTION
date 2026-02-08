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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if(root==null){
            return output;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0;i<length;i++){
                TreeNode poppedNode = queue.remove();
                if(i==length-1){
                    //Last Node in the depth level.
                    output.add(poppedNode.val);
                }
                if(poppedNode.left!=null){
                    queue.add(poppedNode.left);
                }
                if(poppedNode.right!=null){
                    queue.add(poppedNode.right);
                }
            }
        }
        return output;
    }
}