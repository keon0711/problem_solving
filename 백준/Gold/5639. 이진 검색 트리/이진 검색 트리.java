import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> preorder = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            preorder.add(sc.nextInt());
        }

        postorder(preorder, 0, preorder.size() - 1);
    }

    static void postorder(List<Integer> preorder, int start, int end) {
        if(start > end) return;

        int root = preorder.get(start);
        int idx = start + 1;

        // 오른쪽 서브트리의 시작점 찾기
        while(idx <= end && preorder.get(idx) < root) idx++;

        postorder(preorder, start + 1, idx - 1);  // 왼쪽 서브트리
        postorder(preorder, idx, end);            // 오른쪽 서브트리
        System.out.println(root);
    }
}