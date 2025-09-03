class Solution 
{
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
       int total_left=0;
       for(int i=0;i<gas.length;i++)
       {
        total_left+=gas[i]-cost[i];
       } 
       if(total_left<0)
       return -1;
       int startIndex=0;
       int remaining=0;
       for(int i=0;i<gas.length;i++)
       {
        int currentGas=gas[i]+remaining;
        int currentCost=cost[i];
        remaining=currentGas-currentCost;
        if(remaining<0)
        {
            remaining=0;
            startIndex=i+1;
        }
       }
       return startIndex;
    }
}
