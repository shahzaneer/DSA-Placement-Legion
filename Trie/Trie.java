public class Trie {  
    // Root is the only data member of the Trie class
    private Node root = null;
    // Trie jb bnnega tb srfff aik root Node hogaa hmare pass
    Trie(){
        root = new Node();
    }
    //! Insert  word
    void insertWord(String word){
        Node movingNode = root;
        for(int i=0; i<word.length(); i++){
            if(!movingNode.containsChar(word.charAt(i))){
                movingNode.putNode(word.charAt(i));
            }
            // you have to move anyways na mile tou bana kr , mile tou wese hi
            movingNode = movingNode.getNode(word.charAt(i));
        }
        movingNode.setEnd();
    }
    //! Search word
    boolean searchWord(String word){
        Node movingNode = root;
        for(int i=0; i<word.length(); i++){
            if(!movingNode.containsChar(word.charAt(i))){
                return false;
            }
            else movingNode = movingNode.getNode(word.charAt(i));
        }
        return movingNode.isEnd();
    }
    //! Search Prefix (startsWith)
    boolean startsWith(String prefix){
        Node movingNode = root;
        for(int i=0; i<prefix.length(); i++){
            if(!movingNode.containsChar(prefix.charAt(i))){
                return false;
            }
            else movingNode = movingNode.getNode(prefix.charAt(i));  
        }
        return true;
    }
    //!  Delete word  
    boolean deleteWord(String word){
        Node movingNode = root;
        for(int i=0; i<word.length(); i++){
            if(!movingNode.containsChar(word.charAt(i))){
                return false;
            }
            else movingNode = movingNode.getNode(word.charAt(i));
        }
        boolean foundWord = movingNode.isEnd();

        if(foundWord){
            movingNode.removeEnd();
            return true;
        }
        return false; 

    }

    static class Node{
        Node [] links;
        boolean flag;

        Node(){
            links = new Node [26];
            flag = false;
        }

        boolean containsChar(char ch){
            return links[ch - 'a'] != null;
        }

        void putNode(char ch){
            Node node = new Node();
            links[ch - 'a'] = node;
        }

        Node getNode(char ch){
            return links[ch - 'a'];
        }

        boolean isEnd(){
            return flag;
        }

        void removeEnd(){
            flag = false;
        }

        void setEnd(){
            flag = true;
        }
    
    }

    
}


