

public class Main {
 public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insertWord("shahzaneer");
    trie.insertWord("noor");
    trie.insertWord("hammad");
    trie.insertWord("sameem");
    trie.insertWord("ahtisham");

    System.out.println(trie.searchWord("shahzaneer")); // true
    System.out.println(trie.startsWith("no")); // true
    System.out.println(trie.deleteWord("noor")); // true
    System.out.println(trie.searchWord("no")); // false

 }    
}
