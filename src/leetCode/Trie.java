package leetCode;

/**
 * @author fengjie
 * @date 2019:04:08
 */
public class Trie {
    private TrieNode root;

    private class TrieNode {
        TrieNode[] child = new TrieNode[26];

        boolean isWorld;
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.child[i] == null) p.child[i] = new TrieNode();
            p = p.child[i];
        }
        p.isWorld = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.child[i] == null) return false;
            p = p.child[i];
        }
        return p.isWorld;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (p.child[i] == null) return false;
            p = p.child[i];
        }
        return true;
    }

}
