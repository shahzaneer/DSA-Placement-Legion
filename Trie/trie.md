# Trie
- A `trie` (pronounced as "try") or `prefix tree` is a tree data structure used to `efficiently store and retrieve keys in a dataset of strings`.
- There are various applications of this data structure, such as autocomplete and spellchecker.
- Trie is a data structure that is like a tree data structure in its organisation. 
- It consists of nodes that store letters or alphabets of words, which can be added, retrieved, and deleted from it in a very efficient way.

## Complexity Analysis
### Time Complexity:

- `Insertion: O(N)` where N is the length of the word being inserted. This is because we have to iterate over each letter of the word to find its corresponding node or create a node accordingly.
- `Search: O(N)` where N is the length of the word being searched for. This is because in Trie search we traverse over each letter for the word from the root, checking if the current node contains a node at the index of the next letter. This process repeats until we reach the end of the word or encounter a node without the next letter.
- `Prefix Search: O(N)` where N is the length of the prefix being searched for. Similar to searching for words, in prefix search we also iterate over each letter of the word to find its corresponding node.
### Space Complexity: O(N) 
- where N is the total number of characters across all unique words inserted into the Trie. For each character in a word, a new node may need to be created leading to space proportional to the number of characters.
## why Trie?
-It organises strings such that common prefixes are shared among strings, making operations like searching for words with a given prefix efficient. Trie allows for quick retrieval of all strings with a given prefix, making it highly efficient for autocomplete and predictive text applications.

## How Trie?
A Trie node is a data structure used to construct Trie. Each node contains the following components:

Links to Child Nodes: A Trie node contains an array of pointers called “links” or “pointer to children” for each letter of the lowercase alphabet. These pointers represent connections to child nodes corresponding to each letter of the alphabet. For instance, the link at index 0 corresponds to the child node representing the letter 'a', the link at index 1 corresponds to 'b', and so forth.
Flag for End of Word: Each Trie node contains a boolean flag indicating whether the node marks the end of a word. This flag is essential for distinguishing between prefixes and complete words stored in the Trie.
