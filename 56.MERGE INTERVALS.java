class Solution
 {
    public int[][] merge(int[][] intervals) 
    {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int index=0;
        List<int[]>resList=new ArrayList<>();
        while(index<intervals.length)
        {
            int newStart=intervals[index][0];
            int currEnd=intervals[index][1];
            while(index<intervals.length-1 && currEnd>=intervals[index+1][0])
            {
                currEnd=Math.max(currEnd, intervals[index+1][1]);
                index+=1;
            }
            int newEnd=currEnd;
            resList.add(new int[]{newStart,newEnd});
            index+=1;
        }
        index=0;
        int[][]res=new int[resList.size()][2];
        for(int[]arr:resList)
        {
            res[index++]=arr;
        }
        return res;
    }
}
