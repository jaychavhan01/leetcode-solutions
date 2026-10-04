class Solution {
    public double average(int[] salary) {
        int sum=0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<salary.length;i++) {
            sum+= salary[i];
            if(salary[i]>max) max = salary[i];
            if(salary[i]<min) min = salary[i];
        }
        sum = sum - max - min;
        double avg = (double)sum/(salary.length-2);
        return avg;
    }
}