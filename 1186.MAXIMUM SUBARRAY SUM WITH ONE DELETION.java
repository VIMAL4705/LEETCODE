class Solution 
{
    public int maximumSum(int[] arr) 
    {
        int high = Integer.MIN_VALUE;
        for (int a : arr) 
        {
            high = Math.max(high, a);
        }
        if (high < 0) 
        {
            return high; 
        }

        int[] forward = new int[arr.length];
        int currMax = 0;
        for (int i = 0; i < arr.length; i++) 
        {
            int a = arr[i];
            currMax = Math.max(currMax + a, a);
            forward[i] = currMax;
        }

        int[] backward = new int[arr.length];
        currMax = 0;
        int bestMax = 0;
        for (int i = arr.length - 1; i >= 0; i--) 
        {
            int a = arr[i];
            currMax = Math.max(currMax + a, a);
            bestMax = Math.max(currMax, bestMax);
            backward[i] = currMax;
        }

        int o = bestMax; 
        for (int i = 1; i < arr.length - 1; i++) 
        {
            o = Math.max(o, forward[i - 1] + backward[i + 1]); 
        }
        return o;
    }
}
