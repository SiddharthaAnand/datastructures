# https://www.interviewbit.com/problems/pascal-triangle/

class Solution:
    # @param A : integer
    # @return a list of list of integers
    def solve(self, A):
        result = [[0 for x in range(A)] for y in range(A)]
        
        for idx in range(A):
            for j in range(idx+1):
                if j == 0 or j == idx:
                    result[idx][j] = 1
                else:
                    result[idx][j] = result[idx-1][j-1] + result[idx-1][j]
        
        res = []
        for i in range(A):
            res.append(result[i][:i+1])
            
        return res