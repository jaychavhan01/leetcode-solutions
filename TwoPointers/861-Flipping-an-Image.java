class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++) {
            int st = 0;
            int end = image[0].length-1;
            while(st<end) {
                int temp = image[i][st];
                image[i][st] = image[i][end];
                image[i][end] = temp;
                st++;
                end--;
            }
        }
        for(int i = 0;i<image.length;i++) {
            for(int j=0;j<image[0].length;j++) {
                if(image[i][j]==0) {
                    image[i][j]=1;
                }
                else {
                    image[i][j]=0;
                }
            }
        }
        return image;
    }
}