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

 class Pair{
    TreeNode node ;
    int idx;
    Pair(TreeNode n, int i ){
        node = n;
        idx=i;
    }
 }

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth =-1;

        // TreeNode curr = root;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        // int maxWidth=0;


        while(!q.isEmpty()){
            int lvlLength = q.size();
            int index=0;
            int startAt= q.peek().idx;

            for(int i=0;i<lvlLength;i++){
                Pair p = q.poll();
                TreeNode curr = p.node;
                 index = p.idx;

                if(curr.left!=null){
                    q.add(new Pair(curr.left, 2*index+1));
                }

                if(curr.right!=null){
                    q.add(new Pair(curr.right, 2*index+2));
                }


            }

            maxWidth = Math.max(maxWidth, index-startAt + 1);



            // TreeNode curr = q.poll();
            
        }


        return maxWidth;
    }
}