import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    
    
    TreeNode(int data){
        this.data = data;
    }

    // ! PreOrderTraversal 
    //? (recursive)
    static List<Integer> preOrderTraversal(TreeNode root){
      List<Integer> list = new ArrayList<>();
      preOrderTraversalHelper(root, list);
      return list; 

    }
    // here using the concept of pass by reference
    static private void preOrderTraversalHelper(TreeNode root, List<Integer> list) {
        if(root == null) return;
        list.add(root.data);
        preOrderTraversalHelper(root.left, list);
        preOrderTraversalHelper(root.right, list);
    }

    //? interative 
    // ! PostOrderTraversal
    static List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        postOrderTraversalHelper(root, list);
        return list; 
  
      }
      // here using the concept of pass by reference
      static private void postOrderTraversalHelper(TreeNode root, List<Integer> list) {
          if(root == null) return;
          postOrderTraversalHelper(root.left, list);
          postOrderTraversalHelper(root.right, list);
          list.add(root.data);
      }
    // ! InorderTraversal
    static List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inOrderTraversalHelper(root, list);
        return list; 
  
      }
      // here using the concept of pass by reference
      static private void inOrderTraversalHelper(TreeNode root, List<Integer> list) {
          if(root == null) return;
          inOrderTraversalHelper(root.left, list);
          list.add(root.data);
          inOrderTraversalHelper(root.right, list);
      }
  

    // ! Level Order Traversal
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentList = new LinkedList<>();
            for(int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                currentList.add(node.data);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            list.add(currentList);
        }

        return list;

    }

        //! zigZag Order Traversal
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

         List<List<Integer>> list = new LinkedList<>();
         if (root == null) return list;

         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         boolean leftToRight = false;

         while(!queue.isEmpty()){
            int levelSize = queue.size();
            int [] currentList = new int [levelSize];

            for(int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                int index = leftToRight? i : levelSize - 1 - i;
                currentList[index] = node.data;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
              List<Integer> integerList = Arrays.stream(currentList)  // Convert int[] to IntStream
                                          .boxed()           // Convert IntStream to Stream<Integer>
                                          .toList();         // Collect into List<Integer>
        
            list.add(integerList);
            leftToRight = !leftToRight;
         }

         return list;

        }
                      

    // ! Height of a Tree / Maximum Depth
    // remember the recurrence relation
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftSubTreeHeight = maxDepth(root.left);
        int rightSubTreeHeight = maxDepth(root.right);
        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight); 
    }

    // ! Check if a tree is balanced BT or not
    public static int checkHeight(TreeNode root){
        if(root == null) return 0;

        int leftSubTreeHeight = checkHeight(root.left);
        if(leftSubTreeHeight == -1) return -1;
        int rightSubTreeHeight = checkHeight(root.right);
        if(rightSubTreeHeight == -1) return -1;

        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);

    }
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root)!= -1;
    }

    // ! Diamter of the Binary Tree
    //  Maximum possible Distance between two nodes (not necessarily be passing thorugh the root)
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

    // ! isSame Tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return (p==q);
        return (p.data == q.data) &&  isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }



     public static boolean isSymmetric(TreeNode root) {
        return root == null || helperIsSymmetricHelper(root.left, root.right);
    }

    static boolean helperIsSymmetricHelper(TreeNode left, TreeNode right){
        if(left == null || right== null) return left == right;
        if(left.data!=right.data) return false;
        return helperIsSymmetricHelper(left.left, right.right) && helperIsSymmetricHelper(left.right, right.left);
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(11);

        node1.left = node2;
        node1.right = node3;

        TreeNode root = node1;
        List<Integer> list = preOrderTraversal(root);
        System.out.println(list);
    }
   
}
