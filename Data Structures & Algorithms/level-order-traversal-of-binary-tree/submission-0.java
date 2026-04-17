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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        q.add(root);
        q.add(new TreeNode(-1001));
        ArrayList<Integer> cur = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode x = q.poll();
            if(x.val == -1001){
                continue;
            }
            cur.add(x.val);
            if(x.left != null){
                q.add(x.left);
            }
            if(x.right != null){
                q.add(x.right);
            }
            if(!q.isEmpty() && q.peek().val == -1001){
                ans.add(List.copyOf(cur));
                cur = new ArrayList<Integer>();
                q.add(new TreeNode(-1001));
            }

        }
        return ans;
    }
}
