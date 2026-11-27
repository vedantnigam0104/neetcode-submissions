class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(root.val > key)
        {
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key)
        {
            root.right = deleteNode(root.right, key);
        }
        else
        {
            // No left child
            if(root.left == null)
                return root.right;

            // No right child
            if(root.right == null)
                return root.left;

            // Two children
            TreeNode curr = root.right;

            while(curr.left != null)
                curr = curr.left;

            root.val = curr.val;

            root.right = deleteNode(root.right, curr.val);
        }

        return root;
    }
}