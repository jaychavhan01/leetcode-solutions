class Solution {
    public void moveZeroes(int[] ar) {
        int j=0;
		 for(int i=0;i<ar.length;i++) {
			 if(ar[i]!=0) {
				 int temp = ar[i];
				 ar[i]=ar[j];
				 ar[j]=temp;
				 j++;
			 }
		 }
    }
}