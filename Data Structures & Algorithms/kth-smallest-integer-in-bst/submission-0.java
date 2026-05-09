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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<TreeNode> lst = new ArrayList<>();
        inorder(root, lst);
        return lst.get(k-1).val;
    }
    public void inorder(TreeNode node, ArrayList<TreeNode> list){
        if(node == null){
            return;
        }
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }
}
