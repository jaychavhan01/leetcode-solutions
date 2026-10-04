class Solution {
    public void rotate(int[][] matrix) {
        int col = matrix[0].length-1;
        for(int i=0;i<matrix.length;i++) {
            for(int j=i+1;j<matrix[0].length;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<matrix.length;i++) {
            int st = 0;
            int end = col;
            while(st<end) {
                int temp = matrix[i][st];
                matrix[i][st] = matrix[i][end];
                matrix[i][end] = temp;
                st++;
                end--;
            }
        }

    }
}