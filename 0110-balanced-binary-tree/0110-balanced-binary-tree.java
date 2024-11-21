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
     public static int checkHeight(TreeNode root){
        if(root == null) return 0;

        int leftSubTreeHeight = checkHeight(root.left);
        if(leftSubTreeHeight == -1) return -1;
        int rightSubTreeHeight = checkHeight(root.right);
        if(rightSubTreeHeight == -1) return -1;

        
        if(Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) return -1;

        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);

    }
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root)!= -1;
    }
}