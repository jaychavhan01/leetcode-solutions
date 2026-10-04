class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        int m[]=new int[n+1];
	   m[0]=0;
	   m[1]=1;
	   for(int i=2; i<m.length; i++)
	   {
		    m[i]=m[i-1]+m[i-2];
	   }
	   return m[n];

    }
}