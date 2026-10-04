class Solution {
    public double findMedianSortedArrays(int[] array1, int[] array2) {
        int n1=array1.length;
        int n2=array2.length;
        int i=0,j=0,k=0;
        int mergedArray[] = new int[n1+n2];
        int n3 = n1+n2;
        while (i < n1 && j < n2) {
            if (array1[i] <= array2[j]) {
                mergedArray[k++] = array1[i++];
            } else {
                mergedArray[k++] = array2[j++];
            }
        }
        while (i < n1) {
            mergedArray[k++] = array1[i++];
        }
        while (j < n2) {
            mergedArray[k++] = array2[j++];
        }
        if(mergedArray.length%2!=0) {
            int ind = n3/2;
            return (double)mergedArray[ind];
        }
        else {
            int ind2 = n3/2;
            int sum = mergedArray[ind2-1]+mergedArray[ind2];
            double avg = (double)sum/2;
            return avg;
        }
    }
}