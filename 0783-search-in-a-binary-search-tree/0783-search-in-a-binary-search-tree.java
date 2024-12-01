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
   public TreeNode searchBST(TreeNode root, int val) {
        TreeNode [] searchedRoot = new TreeNode[1];
        searchBSTreeNode(root, val, searchedRoot);
        return searchedRoot[0];
    }

    public static void searchBSTreeNode(TreeNode root, int val, TreeNode [] searchedRoot){
        if(root  == null) return;
        if(root.val == val) searchedRoot[0] = root;
        searchBSTreeNode(root.left, val, searchedRoot);
        searchBSTreeNode(root.right, val, searchedRoot);
    }
}