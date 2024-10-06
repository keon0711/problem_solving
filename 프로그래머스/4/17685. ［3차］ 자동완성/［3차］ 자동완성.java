import java.util.*;

class Solution {

    public int solution(String[] words) {
        Trie trie = new Trie();


        for (String word : words) {
            trie.insert(word);
        }

        int answer = 0;
        for (String word : words) {
            int prefixCount = trie.getPrefixCount(word);
            answer += prefixCount;
        }
        return answer;
    }

    static class Trie {

        Node root;

        public Trie() {
            root = new Node();
        }


        public void insert(String word) {
            Node node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Node();
                }
                node = node.children[c - 'a'];
                node.count++;
            }
        }

        public int getPrefixCount(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.count == 1) {
                    return i;
                }
                node = node.children[word.charAt(i) - 'a'];

            }
            return word.length();
        }
    }

    static class Node {

        Node[] children = new Node[26];
        int count;

        public Node() {
            this.count = 0;
        }
    }
}