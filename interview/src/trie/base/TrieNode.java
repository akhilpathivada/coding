/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 */
package trie.base;

public class TrieNode {
        
        public TrieNode[] trie; // each characters' index acts as a pointer

        public boolean isEndOfString; // tells if the string ends here or not

        public TrieNode() {
                trie = new TrieNode[256];
                // iterates over 256 indexes and initializes as null
                for (int i = 0; i < 256; ++i) {
                        trie[i] = null;
                }
                isEndOfString = false;
        }
}
