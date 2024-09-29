class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            
            int minDistance = Integer.MAX_VALUE;
            
            // 왼쪽 벽
            if (!(startY == targetY && startX > targetX)) {
                int dist = calculateDistance(-startX, startY, targetX, targetY);
                minDistance = Math.min(minDistance, dist);
            }
            
            // 오른쪽 벽
            if (!(startY == targetY && startX < targetX)) {
                int dist = calculateDistance(2*m-startX, startY, targetX, targetY);
                minDistance = Math.min(minDistance, dist);
            }
            
            // 아래쪽 벽
            if (!(startX == targetX && startY > targetY)) {
                int dist = calculateDistance(startX, -startY, targetX, targetY);
                minDistance = Math.min(minDistance, dist);
            }
            
            // 위쪽 벽
            if (!(startX == targetX && startY < targetY)) {
                int dist = calculateDistance(startX, 2*n-startY, targetX, targetY);
                minDistance = Math.min(minDistance, dist);
            }
            
            answer[i] = minDistance;
        }
        
        return answer;
    }
    
    private int calculateDistance(int x1, int y1, int x2, int y2) {
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }
}