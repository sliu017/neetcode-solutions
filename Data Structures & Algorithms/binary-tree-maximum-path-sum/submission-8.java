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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int x = solve(root);
        return Math.max(ans, root.val);
    }
    public int solve(TreeNode node){
        if(node.left == null && node.right == null){
            ans = Math.max(ans, node.val);
            return node.val;
        } else if(node.left == null || node.right == null){
            TreeNode has = node.left == null ? node.right : node.left;
            int fromGoingDown = solve(has);
            int ret = Math.max(node.val, node.val+fromGoingDown);
            ans = Math.max(ret, ans);
            return ret;
        } else {
            // Set MAX to 0 for these bc we can choose to not go down the paths 
            // (might have error later if both paths are negative)
            int l = solve(node.left); 
            int r = solve(node.right);
            int here = Math.max(Math.max(node.val + l, node.val + r),
            Math.max(node.val + l + r, node.val));
            ans = Math.max(here, ans);
            int ret = Math.max(Math.max(node.val + l, node.val + r), node.val);
            return ret;
        }
    }
}
