class Solution 
{
    public int[] topKFrequent(int[] nums, int k) 
    {
        Map<Integer, Integer>countMap =new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!countMap.containsKey(nums[i]))countMap.put(nums[i],0);
            countMap.put(nums[i],countMap.get(nums[i])+1);
        }
        Map<Integer,List<Integer>>reverseCountMap=new HashMap<>();
        for(int num:countMap.keySet())
        {
            int count=countMap.get(num);
            if(!reverseCountMap.containsKey(count))reverseCountMap.put(count,new ArrayList<Integer>());
            reverseCountMap.get(count).add(num);
        }
        int[]result=new int[k];
        int index=0;
        for(int possibleCount=nums.length;possibleCount>=1;possibleCount--)
        {
            if(reverseCountMap.containsKey(possibleCount))
            {
                for(int n:reverseCountMap.get(possibleCount))
                {
                    if(index < k)
                    result[index++]=n;
                    else
                    break;
                }
            }
            if(index>=k)
        break;
        }
        return result;
    }
}
