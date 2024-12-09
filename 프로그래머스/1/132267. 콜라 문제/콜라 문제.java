class Solution {
    public int solution(int a, int b, int n) {
        int totalCokes = 0;
        
        while (n >= a) {
            int newCokes = (n / a) * b;
            int leftover = n % a;
            n = newCokes + leftover;
            totalCokes += newCokes;
        }
        
        return totalCokes;
    }
}