class Solution {
    public int[][] generateMatrix(int n) {
        int mat[][] = new int[n][n];
        int left = 0,right=n-1;
        int top = 0,bottom=n-1;
        int num = 1;
        while(left<=right&&top<=bottom) {
            for(int i=left;i<=right;i++) {
                mat[top][i] = num++;
            }
            top++;

            for(int i=top;i<=bottom;i++) {
                mat[i][right] = num++;
            }
            right--;

            if(top<=bottom) {
				for(int i=right;i>=left;i--) {
                    mat[bottom][i] = num++;
				}
			}
			bottom--;
			if(left<=right) {
				for(int i=bottom;i>=top;i--) {
                    mat[i][left] = num++;
				}
			}
            left++;
        }
        return mat;
    }
}