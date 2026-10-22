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
        List<Integer> li=new ArrayList<>();

        if(root==null)
            return new ArrayList<>();

        Queue<TreeNode> pq=new LinkedList<>();

        pq.offer(root);

        while(!pq.isEmpty())
        {
            int size=pq.size();

            for(int i=0;i<size;i++)
            {
                TreeNode node=pq.poll();

                if(i==0)
                    li.add(node.val);

                if(node.right!=null)
                    pq.offer(node.right);     

                if(node.left!=null)
                    pq.offer(node.left);       
            }
        }
        return li;    
    }
}
