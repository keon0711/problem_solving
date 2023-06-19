from collections import deque

def solution(places):
    def bfs(x, y, d):
        Q = deque([(x, y, d)])
        visited = set()
        visited.add((x, y))
        
        while Q:
            cur_x, cur_y, dist = Q.popleft()
            if dist >= 2:
                return True
            
            for i in range(4):
                nx = cur_x + dx[i]
                ny = cur_y + dy[i]
                if 0 <= nx < 5 and 0 <= ny < 5 and (nx, ny) not in visited and place[nx][ny] != 'X':
                    if place[nx][ny] == 'P':
                        return False
                    visited.add((nx, ny))
                    Q.append((nx, ny, dist + 1))
                    
        return True
    
    def check_place():
        for i in range(5):
            for j in range(5):
                if place[i][j] == 'P':
                    if not bfs(i, j, 0):
                        result.append(0)
                        return
        
        result.append(1)
        return
        
    
    dx = [1, 0, 0, -1]
    dy = [0, -1, 1, 0]
    
    result = []
    for place in places:
        check_place()
    
    return result