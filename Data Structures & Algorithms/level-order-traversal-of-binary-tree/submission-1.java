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
        List<List<Integer>> res=new ArrayList<>();

        if(root==null)
            return res;

        List<Integer> temp=new ArrayList<>();

        Queue<TreeNode> pq=new LinkedList<>();

        pq.offer(root);

        while(!pq.isEmpty())
        {
            int size=pq.size();

            for(int i=0;i<size;i++)
            {
                TreeNode node=pq.poll();

                temp.add(node.val);

                if(node.left!=null)
                    pq.offer(node.left);

                if(node.right!=null)
                    pq.offer(node.right);
            }

            res.add(temp);

            temp=new ArrayList<>();    
        }
        return res;
    }
}
