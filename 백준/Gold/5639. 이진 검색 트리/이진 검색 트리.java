import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        Node root = new Node(num);

        while (sc.hasNextInt()) {
            Node node = new Node(sc.nextInt());
            root.insert(node);
        }

        root.postorder();
    }

    static class Node {

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public void insert(Node node) {
            if (this.value > node.value) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.insert(node);
                }
            } else {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.insert(node);
                }
            }
        }

        public void postorder() {
            if (left != null) {
                left.postorder();
            }
            if (right != null) {
                right.postorder();
            }
            System.out.println(value);
        }
    }

}