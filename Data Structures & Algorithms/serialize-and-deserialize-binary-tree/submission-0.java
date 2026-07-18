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

public class Codec {
    public class Pair{
        TreeNode node;
        int layer;
        public Pair(TreeNode node, int layer){
            this.node = node;
            this.layer = layer;
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 1));
        int prev = 1;
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int layer = p.layer;

            if(node == null){
                ans.append("N" + "^");
            } else {
                ans.append(node.val+"^");
                if(node.left != null){
                    q.add(new Pair(node.left, layer+1));
                } else {
                    q.add(new Pair(null, layer+1));
                }
                if(node.right != null){
                    q.add(new Pair(node.right, layer+1));
                } else {
                    q.add(new Pair(null, layer + 1));
                }                
            }


        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> q = new ArrayDeque<>();
        int i = 0;
        String rootStr = "";
        while(data.charAt(i) != '^'){
            rootStr += data.charAt(i++);
        }
        if(rootStr.equals("N")){
            return null;
        }
        i++;
        TreeNode currentHigherNode = null;
        TreeNode root = new TreeNode(Integer.valueOf(rootStr));
        q.add(root);
        while(i < data.length()){
            currentHigherNode = q.poll();
            if(data.charAt(i) == 'N'){
                i++;
                currentHigherNode.left = null;
            } else {
                String cur = "";
                while(data.charAt(i) != '^'){
                    cur += data.charAt(i++);
                }
                TreeNode lft = new TreeNode(Integer.valueOf(cur));
                currentHigherNode.left = lft;
                q.add(lft);
            }
            i++;
            if(data.charAt(i) == 'N'){
                i++;
                currentHigherNode.right = null;
            } else {
                String cur = "";
                while(data.charAt(i) != '^'){
                    cur += data.charAt(i++);
                }
                TreeNode rgt = new TreeNode(Integer.valueOf(cur));
                currentHigherNode.right = rgt;
                q.add(rgt);
            }
            i++;
        }
        return root;

    }
}
