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
    int idx = 0;
    HashMap<Integer,Integer> indices = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            indices.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length -1);
    }
    private TreeNode dfs(int[] preorder, int l, int r){
        if(l > r){
            return null;
        }
        int rval = preorder[idx++];
        TreeNode root = new TreeNode(rval);
        int mid = indices.get(rval);
        root.left = dfs(preorder, l , mid-1);
        root.right = dfs(preorder, mid + 1, r);
        return root;
    }
}
