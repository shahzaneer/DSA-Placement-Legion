import java.util.ArrayList;
import java.util.List;

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
