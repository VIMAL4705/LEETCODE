class Solution 
{
    public int findMinArrowShots(int[][] points) 
    {
        Arrays.sort(points, (a,b)->Integer.compare(a[1],b[1]));
        int arrows=0;
        long end=Long.MIN_VALUE;
        for(int[]balloon:points)
        {
            if(balloon[0]>end)
            {
                arrows++;
                end=balloon[1];
            }
        }
        return arrows;
    }
}
