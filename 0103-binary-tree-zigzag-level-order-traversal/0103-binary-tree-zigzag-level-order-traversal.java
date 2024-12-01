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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
         if (root == null) return list;
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         boolean leftToRight = true;

         while(!queue.isEmpty()){
            int levelSize = queue.size();
            int [] currentList = new int [levelSize];

            for(int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                int index = leftToRight? i : levelSize - 1 - i;
                currentList[index] = node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
    List<Integer> integerList = Arrays.stream(currentList).boxed().toList();        
        
            list.add(integerList);
            leftToRight = !leftToRight;
         }

         return list;

    }
}