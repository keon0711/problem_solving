import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 이름과 그리움 점수를 매핑하는 해시맵 생성
        Map<String, Integer> yearningMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            yearningMap.put(name[i], yearning[i]);
        }

        // 각 사진의 추억 점수를 저장할 배열
        int[] answer = new int[photo.length];

        // 각 사진에 대해 추억 점수 계산
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (String person : photo[i]) {
                sum += yearningMap.getOrDefault(person, 0);
            }
            answer[i] = sum;
        }

        return answer;
    }
}