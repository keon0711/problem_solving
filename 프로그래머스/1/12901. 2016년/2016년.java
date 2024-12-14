import java.util.*;

class Solution {
    public String solution(int a, int b) {
        // 각 월의 일 수 (윤년 기준)
        int[] daysInMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] daysOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        // 해당 월 전까지의 누적 일수 계산
        int totalDays = b;
        for (int i = 1; i < a; i++) {
            totalDays += daysInMonth[i];
        }
        
        // 요일 계산
        String answer = daysOfWeek[(totalDays - 1) % 7];
        return answer;
    }
}