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
    public int diameterOfBinaryTree(TreeNode root) {
        int [] diameter = new int [1];
        height(root, diameter);
        return diameter[0];
    }
    
    public static int height(TreeNode root, int [] maxi) {
        if(root == null) return 0;

        int leftSubTreeHeight = height(root.left, maxi);
        int rightSubTreeHeight = height(root.right, maxi);
        maxi[0] = Math.max(maxi[0], leftSubTreeHeight + rightSubTreeHeight);

        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight); 
    }

}