import java.util.regex.*;

class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        // 옹알이 조건을 만족하는 정규식 (반복 방지 포함)
        String pattern = "^(?!.*(ayaaya|yeye|woowoo|mama))(aya|ye|woo|ma)+$";
        Pattern regex = Pattern.compile(pattern);

        for (String word : babbling) {
            Matcher matcher = regex.matcher(word);
            if (matcher.matches()) {
                count++;
            }
        }
        return count;
    }
}