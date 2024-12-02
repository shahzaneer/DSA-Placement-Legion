

public class BSTreeNode {
    int data;
    BSTreeNode left;
    BSTreeNode right;
    
    
    BSTreeNode(int data){
        this.data = data;
    }

    // ! Search in BST

    public BSTreeNode searchBST(BSTreeNode root, int val) {
        BSTreeNode [] searchedRoot = new BSTreeNode[1];
        searchBSTreeNode(root, val, searchedRoot);
        return searchedRoot[0];
    }

    public static void searchBSTreeNode(BSTreeNode root, int val, BSTreeNode [] searchedRoot){
        if(root  == null) return;
        if(root.data == val) searchedRoot[0] = root;
        searchBSTreeNode(root.left, val, searchedRoot);
        searchBSTreeNode(root.right, val, searchedRoot);
    }
   
    // ! isValid BST or not
public boolean isValidBST(BSTreeNode root) {
       return validBSTOrNot(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean validBSTOrNot(BSTreeNode root, int minValue, int maxValue){
        if(root == null) return true;
        if(root.data <= minValue || root.data >= maxValue) return false;

        return validBSTOrNot(root.left, minValue, root.data) && validBSTOrNot(root.right, root.data , maxValue);
    }
// ! Smallest and Largest Element of a BST

static int smallestElementBST(BSTreeNode root){
    if(root == null) return -1;

    while(root.left!=null){
        root = root.left;
    }
    return root.data;
}

static int largestElementBST(BSTreeNode root){
    if(root == null) return -1;

    while(root.right!=null){
        root = root.right;
    }
    return root.data;
}

}

    
