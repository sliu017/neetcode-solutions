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
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        q.add(root);
        while(!q.isEmpty()){
            int val = 2026;
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                TreeNode x = q.poll();
                if(x != null){
                    val = x.val;
                    q.add(x.left);
                    q.add(x.right);
                }
            }
            if(val != 2026){
                ans.add(val);
            }
        }
        return ans;
    }
}
