class Solution 
{
    public List<List<Integer>> combinationSum(int[] c, int t) 
    {
       List<List<Integer>> result=new ArrayList<>();
       Arrays.sort(c);
       back(c,t,0,new ArrayList<>(),result);
       return result;
    }
    private void back(int c[],int t,int s,List<Integer>cur,List<List<Integer>>result)
    {
        if(t==0)
        {
            result.add(new ArrayList<>(cur));
            return;
        }
        for(int i=s;i<c.length;i++)
        {
            if(c[i]>t)
            {
                break;
            }
            cur.add(c[i]);
            back(c,t-c[i],i,cur,result);
            cur.remove(cur.size()-1);
        }
    }
}
