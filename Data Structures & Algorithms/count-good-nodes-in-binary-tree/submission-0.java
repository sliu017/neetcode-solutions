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
    public int ans;
    public int goodNodes(TreeNode root) {
        ans = 0;
        search(root, root.val);
        return ans;
    }
    public void search(TreeNode node, int max){
        // if(node.left == null && node.right == null){
        //     if(node.val >= max){
        //         ans++;
        //     }
        // }
        if(node.val >= max){
            ans++;
        }
        max = Math.max(max,node.val);
        if(node.left != null){
            search(node.left, max);
        }
        if(node.right != null){
            search(node.right, max);
        }
    }
}
