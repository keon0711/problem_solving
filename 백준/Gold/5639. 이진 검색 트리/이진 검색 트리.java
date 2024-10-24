import java.util.*;

public class Main {
    static class Frame {
        int start;
        int end;
        boolean isProcessed;

        Frame(int start, int end) {
            this.start = start;
            this.end = end;
            this.isProcessed = false;
        }
    }

    public static void main(String[] args) {
        List<Integer> preorder = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            preorder.add(sc.nextInt());
        }

        postorderUsingDeque(preorder);
    }

    static void postorderUsingDeque(List<Integer> preorder) {
        if (preorder.isEmpty()) return;

        Deque<Frame> deque = new ArrayDeque<>();
        // 루트 노드 처리
        deque.push(new Frame(0, preorder.size() - 1));

        while (!deque.isEmpty()) {
            Frame current = deque.peek();

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
                    deque.push(new Frame(idx, current.end));
                }

                // 왼쪽 서브트리가 있는 경우 스택에 추가
                if (current.start + 1 < idx) {
                    deque.push(new Frame(current.start + 1, idx - 1));
                }
            } 
            // 자식 노드를 모두 처리한 경우
            else {
                Frame completed = deque.pop();
                System.out.println(preorder.get(completed.start));
            }
        }
    }
}