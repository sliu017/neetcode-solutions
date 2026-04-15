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
    HashMap<TreeNode,Integer> heights = new HashMap<>();
    boolean ok = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ok;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        if(Math.abs(l-r) > 1){
            ok = false;
        }
        return 1 + Math.max(l,r);
    }
}
