class Solution {
    public int solution(String s) {
        if (s.length() == 0) {
            return 0;
        }

        char firstChar = s.charAt(0);

        int first = 1;
        int others = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == firstChar) {
                first++;
            } else {
                others++;
            }

            if (first == others) {
                return 1 + solution(s.substring(i + 1));
            }
        }

        return 1;
    }
}