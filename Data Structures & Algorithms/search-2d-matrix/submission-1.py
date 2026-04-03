class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix is None or len(matrix) == 0:
            return False

        m = len(matrix)
        n = len(matrix[0])
        if target<matrix[0][0] or target>matrix[m-1][n-1]:
            return False
        
        minRow = 0
        maxRow = m-1
        row = -1
        while minRow<=maxRow:
            midRow = minRow + (maxRow-minRow)//2
            if (matrix[midRow][0]<=target<=matrix[midRow][n-1]):
                row = midRow
                break
            elif (target<matrix[midRow][n-1]):
                maxRow=midRow-1
            else:
                minRow=midRow+1
        
        if row==-1:
            return False

        minCol=0
        maxCol=n-1
        while minCol<=maxCol:
            midCol = minCol + (maxCol-minCol)//2
            if (target==matrix[row][midCol]):
                return True
            elif (target<matrix[row][midCol]):
                maxCol = midCol-1
            else:
                minCol = midCol+1
        
        return False
