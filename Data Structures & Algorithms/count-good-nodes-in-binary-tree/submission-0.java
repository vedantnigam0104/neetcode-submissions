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

class Solution 
{
    public int goodNodes(TreeNode root) 
    {
        if(root==null)
            return 0;
        return count(root,root.val);
    }
    int count(TreeNode root,int max)
    {
        if(root==null)
            return 0;
        
        int c=0;
        
        
        if(root.val>=max)
        {
            c++;
            
            max=root.val;
        }
        
        c+=count(root.left,max);
        
        c+=count(root.right,max);
        
        return c;
    }
}
