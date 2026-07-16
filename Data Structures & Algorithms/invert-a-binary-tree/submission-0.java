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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) 
        {
            TreeNode pq = q.poll();
            TreeNode ch = pq.left;
            pq.left = pq.right;
            pq.right = ch;
            if (pq.left != null)
                q.add(pq.left);
            if (pq.right != null)
                q.add(pq.right);
        }
        return root;
    }
}
