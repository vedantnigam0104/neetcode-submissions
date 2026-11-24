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
     if(root==null)
        return new ArrayList<>();   
     List<List<Integer>> res=new ArrayList<>();

     List<Integer> li=new ArrayList<>();

     Queue<TreeNode> pq=new LinkedList<>();

     pq.add(root);

     while(!pq.isEmpty())
     {
        int size=pq.size();

        for(int i=0;i<size;i++)
        {
            TreeNode node=pq.poll();

            li.add(node.val);

            if(node.left!=null)
                pq.add(node.left);

            if(node.right!=null)
                pq.add(node.right);    
        }
        res.add(li);

        li=new ArrayList<>();
     }
     return res;   
    }
}
