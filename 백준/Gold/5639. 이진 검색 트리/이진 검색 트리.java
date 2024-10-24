import java.util.*;

public class Main {
    static class Frame {
        int start;
        int end;
        int root;
        boolean isProcessed;  // 자식 노드 처리 여부

        Frame(int start, int end, int root) {
            this.start = start;
            this.end = end;
            this.root = root;
            this.isProcessed = false;
        }
    }

    public static void main(String[] args) {
        List<Integer> preorder = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            preorder.add(sc.nextInt());
        }

        postorderUsingStack(preorder);
    }

    static void postorderUsingStack(List<Integer> preorder) {
        if (preorder.isEmpty()) return;

        Stack<Frame> stack = new Stack<>();
        // 루트 노드 처리
        stack.push(new Frame(0, preorder.size() - 1, preorder.get(0)));

        while (!stack.isEmpty()) {
            Frame current = stack.peek();

            // 아직 자식 노드를 처리하지 않은 경우
            if (!current.isProcessed) {
                current.isProcessed = true;
                int idx = current.start + 1;

                // 오른쪽 서브트리의 시작점 찾기
                while (idx <= current.end && preorder.get(idx) < preorder.get(current.start)) {
                    idx++;
                }

                // 오른쪽 서브트리가 있는 경우 스택에 추가
                if (idx <= current.end) {
                    stack.push(new Frame(idx, current.end, preorder.get(idx)));
                }

                // 왼쪽 서브트리가 있는 경우 스택에 추가
                if (current.start + 1 < idx) {
                    stack.push(new Frame(current.start + 1, idx - 1, preorder.get(current.start + 1)));
                }
            } 
            // 자식 노드를 모두 처리한 경우
            else {
                Frame completed = stack.pop();
                System.out.println(preorder.get(completed.start));
            }
        }
    }
}