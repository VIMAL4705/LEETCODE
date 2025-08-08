class Solution 
{
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>>result=new ArrayList<>();
        set(result,new ArrayList<>(),nums,0);
        return result;
    }
    public static void set(List<List<Integer>>r,List<Integer>tl,int[]nums,int s)
    {
        r.add(new ArrayList<>(tl));
        for(int i=s;i<nums.length;i++)
        {
            tl.add(nums[i]);
            set(r,tl,nums,i+1);
            tl.remove(tl.size()-1);
        }
    }
}
