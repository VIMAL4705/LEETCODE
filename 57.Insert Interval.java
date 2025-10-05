class Solution 
{
    public int[][] insert(int[][] intervals, int[] newInterval)
     {
        Stack<int[]> stack = new Stack<>();
        int n = intervals.length, i = 0;
        while(i <= n)
        {
            if(i == n || newInterval[0] <= intervals[i][0])
            {
                if(stack.isEmpty())
                {
                    stack.add(newInterval);
                }
                else if(newInterval[0] <= stack.peek()[1])
                {
                    stack.peek()[1] = Math.max(stack.peek()[1], newInterval[1]);
                }
                else
                {
                    stack.add(newInterval);
                }
                break;
            }
            stack.add(intervals[i]);
            i++;
        }
        for(int j = i; j < n; j++)
        {
            int[] prev = stack.peek();
            if(intervals[j][0] <= prev[1])
            {
                prev[1] = Math.max(intervals[j][1], prev[1]);
            }
            else
            {
                stack.add(intervals[j]);
            }
        }
        
        return stack.toArray(new int[stack.size()][2]);
    }
}
