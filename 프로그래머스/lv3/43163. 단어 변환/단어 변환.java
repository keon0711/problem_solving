import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        List<String> li = new ArrayList<>(List.of(words));
        if (!li.contains(target)) return 0;
        Queue<String> que = new LinkedList<>();
        que.add(begin);
        boolean[] visited = new boolean[words.length];
        int cnt = 0;
        while (!que.isEmpty()) {
            for (int i = 0; i < que.size(); i++) {
                String curWord = que.poll();
                if (curWord.equals(target)) {
                    return cnt;
                }
                for (int j = 0; j < words.length; j++) {
                    String word = words[j];
                    if (!visited[j] && findSimilarWord(curWord, word)) {
                        que.add(word);
                        visited[j] = true;
                    }
                }
            }
            cnt++;
        }

        return cnt;
    }

    public boolean findSimilarWord(String w1, String w2) {
        int cnt = 0;
        char[] cArr1 = w1.toCharArray();
        char[] cArr2 = w2.toCharArray();
        for (int i = 0; i < w1.length(); i++) {
            if (cArr1[i] != cArr2[i])
                cnt++;
        }
        if (cnt == 1)
            return true;
        return false;
    }
}