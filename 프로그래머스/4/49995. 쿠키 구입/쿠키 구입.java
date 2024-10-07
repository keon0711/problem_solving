public class Solution {
    public int solution(int[] cookie) {
        int n = cookie.length;
        int maxCookies = 0;

        // 첫 번째 학생과 두 번째 학생이 받을 수 있는 쿠키의 부분합 계산
        for (int m = 0; m < n - 1; m++) {
            int leftSum = cookie[m];
            int rightSum = cookie[m + 1];
            int left = m;
            int right = m + 1;

            // 왼쪽과 오른쪽의 합을 비교하면서 구간을 확장
            while (true) {
                if (leftSum == rightSum) {
                    maxCookies = Math.max(maxCookies, leftSum); // 동일한 경우 최대 쿠키 수 갱신
                }
                // 구간을 확장할 때 왼쪽으로 확장 가능한지 확인
                if (left > 0 && leftSum <= rightSum) {
                    leftSum += cookie[--left];
                }
                // 구간을 확장할 때 오른쪽으로 확장 가능한지 확인
                else if (right < n - 1 && rightSum <= leftSum) {
                    rightSum += cookie[++right];
                } else {
                    break;
                }
            }
        }
        return maxCookies;
    }
}
