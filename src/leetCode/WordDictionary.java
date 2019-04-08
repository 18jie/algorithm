package leetCode;

/**
 * @author fengjie
 * @date 2019:04:08
 */
public class WordDictionary {
    private TrieNode root;

    private class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isWorld;
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.child[i] == null) p.child[i] = new TrieNode();
            p = p.child[i];
        }
        p.isWorld = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    public boolean searchHelper(String word, int index, TrieNode root) {
        if (index == word.length()) return root.isWorld;
        if (word.charAt(index) == '.') {
            for (TrieNode node : root.child) {
                if (node != null && searchHelper(word, index + 1, node)) return true;
            }
            return false;
        } else {
            return root.child[word.charAt(index) - 'a'] != null && searchHelper(word, index + 1, root.child[word.charAt(index) - 'a']);
        }
    }

}
