class Solution {
    private int k = -1;
    private int currentK = 0;
    private Integer result = null;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return result;
    }

    void inorder(TreeNode node) {
        if (node == null || result != null) { //stop recursion
            return;
        }
        inorder(node.left);

        currentK++;
        if (currentK == k) {
            result = node.val;
            return;
        }

        inorder(node.right);
    }
}