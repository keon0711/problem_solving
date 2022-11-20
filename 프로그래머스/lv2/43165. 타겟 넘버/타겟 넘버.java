class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        int n = numbers[index];
        return dfs(numbers, target, index + 1, sum - n) + dfs(numbers, target, index + 1, sum + n);
    }
}