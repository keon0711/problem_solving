class Solution {

    public int solution(int[] a) {

        if (a.length <= 2) {
            return a.length;
        }
        long[] minFromLeft = new long[a.length];
        long[] minFromRight = new long[a.length];

        for (int i = 0; i < a.length; i++) {
            minFromLeft[i] = a[i];
            minFromRight[i] = a[i];
        }

        for (int i = 1; i < a.length; i++) {
            minFromLeft[i] = Math.min(minFromLeft[i], minFromLeft[i - 1]);
            minFromRight[a.length - 1 - i] = Math.min(minFromRight[a.length - 1 - i], minFromRight[a.length - i]);
        }

        int count = 2;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] <= minFromLeft[i - 1] || a[i] <= minFromRight[i + 1]) {
                count++;
            }
        }

        return count;
    }
}