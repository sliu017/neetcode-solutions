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
    public boolean isValidBST(TreeNode root) {
        return check(root, -1001, 1001);
    }
    public boolean check(TreeNode node, int lower, int upper){
        if(node == null){
            return true;
        } else if(node.val <= lower || node.val >= upper){
            return false;
        } 
        return check(node.left, lower, Math.min(upper, node.val)) && 
               check(node.right, Math.max(lower, node.val), upper);

        
    }
}
