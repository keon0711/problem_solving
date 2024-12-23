class Solution {
    public int solution(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                count++;
                for (int j = i * 2; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        return count;
    }
}