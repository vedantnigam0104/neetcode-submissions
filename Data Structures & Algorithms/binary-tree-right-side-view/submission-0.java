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
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> li=new ArrayList<>();
        
        right(root,li,0);
        
        return li;
    }
    public void right(TreeNode root,List<Integer> li,int l)
    {
        if(root==null)
            return;
        
        if(l==li.size())
            li.add(root.val);
        
        right(root.right,li,l+1);
        
        right(root.left,li,l+1);
    }
}