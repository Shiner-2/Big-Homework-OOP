import java.util.HashMap;

public class Trie {
    public static class TrieNode {
        HashMap<Character, TrieNode> next = new HashMap<>();
        Word current_word = null;
    }

    TrieNode root = new TrieNode();

    /**
     * Get root of trie.
     * @return root of trie
     */
    public TrieNode getRoot() {
        return root;
    }

    /**
     * Add new_word to trie.
     * @param new_word is the word need to add
     */
    public void add_word(Word new_word) {
        TrieNode pNode = getRoot();

        String word_target = new_word.getWord_target();

        for (int i = 0; i < word_target.length(); i++) {
            char currentChar = word_target.charAt(i);

            if (!pNode.next.containsKey(currentChar)) {
                pNode.next.put(currentChar, new TrieNode());
            }

            pNode = pNode.next.get(currentChar);
        }

        pNode.current_word = new_word;
    }
}
