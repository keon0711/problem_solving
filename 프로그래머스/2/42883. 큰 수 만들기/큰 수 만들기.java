class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length() - k;

        for (char num : number.toCharArray()) {
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < num) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(num);
        }

        return sb.substring(0, len);
    }
}