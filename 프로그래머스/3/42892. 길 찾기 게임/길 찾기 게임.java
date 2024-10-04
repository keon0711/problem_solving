import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }
        nodes.sort((a, b) -> b.y != a.y ? b.y - a.y : a.x - b.x);

        Tree tree = new Tree(nodes.get(0));
        for (int i = 1; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            tree.insert(tree.root, node);
        }

        List<Integer> preorderResult = new ArrayList<>();
        List<Integer> postorderResult = new ArrayList<>();
        tree.preOrder(tree.root, preorderResult);
        tree.postOrder(tree.root, postorderResult);

        int[][] res = new int[2][];
        res[0] = preorderResult.stream().mapToInt(a -> a).toArray();
        res[1] = postorderResult.stream().mapToInt(a -> a).toArray();
        return res;
    }

    static class Node {

        int x, y, value;
        Node left, right;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    static class Tree {

        Node root;

        public Tree(Node root) {
            this.root = root;
        }

        public void insert(Node parent, Node child) {
            if (parent.x > child.x) {
                if (parent.left == null) {
                    parent.left = child;
                } else {
                    insert(parent.left, child);
                }
            } else {
                if (parent.right == null) {
                    parent.right = child;
                } else {
                    insert(parent.right, child);
                }
            }
        }

        public void preOrder(Node node, List<Integer> result) {
            if (node == null) {
                return;
            }
            result.add(node.value);
            preOrder(node.left, result);
            preOrder(node.right, result);
        }

        public void postOrder(Node node, List<Integer> result) {
            if (node == null) {
                return;
            }
            postOrder(node.left, result);
            postOrder(node.right, result);
            result.add(node.value);
        }
    }

}