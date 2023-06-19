import sys

def solution(rows, columns, queries):
    def rotate(query):
        min_val = sys.maxsize
        x1, y1, x2, y2 = map(lambda x: x-1, query)
        
        tmp = matrix[x1][y1]
        for i in range(y1, y2):
            min_val = min(min_val, tmp)
            tmp, matrix[x1][i + 1] = matrix[x1][i + 1], tmp
            
            
        for i in range(x1, x2):
            min_val = min(min_val, tmp)
            tmp, matrix[i + 1][y2] = matrix[i + 1][y2], tmp
            
        for i in range(y2, y1, -1):
            min_val = min(min_val, tmp)
            tmp, matrix[x2][i - 1] = matrix[x2][i - 1], tmp
            
        for i in range(x2, x1, -1):
            min_val = min(min_val, tmp)
            tmp, matrix[i - 1][y1] = matrix[i - 1][y1], tmp
        
        min_val = min(min_val, tmp)
        return min_val
        
    
    matrix = [[1 + i + j*columns for i in range(columns)] for j in range(rows)]
    result = []
    for query in queries:
        result.append(rotate(query))
    
    return result