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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderTraversalHelper(root, list);
        return list; 
    }

    // here using the concept of pass by reference
      static private void postOrderTraversalHelper(TreeNode root, List<Integer> list) {
          if(root == null) return;
          postOrderTraversalHelper(root.left, list);
          postOrderTraversalHelper(root.right, list);
          list.add(root.val);
      }
    
}