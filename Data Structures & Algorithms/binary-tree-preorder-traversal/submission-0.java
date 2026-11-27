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
    List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {
       if(root==null)
            return new ArrayList<>();
            
        res=new ArrayList<>();

        help(root);

        return res;
    }

    void help(TreeNode root)
    {
        if(root==null)
            return;

        res.add(root.val);    

        help(root.left);

        help(root.right);    
    } 
}