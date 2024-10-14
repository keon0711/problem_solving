class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        int l = p.length();

        for (int i = 0; i <= t.length() - p.length(); i++) {
            if (t.substring(i, i + l).compareTo(p) <= 0) {
                answer++;
            }
        }

        return answer;
    }
}