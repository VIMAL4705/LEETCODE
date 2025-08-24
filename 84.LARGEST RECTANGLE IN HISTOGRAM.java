class Solution 
{
    public int largestRectangleArea(int[] h) 
    {
      int n=h.length;
      int maxArea=0;
      Stack<Integer>s=new Stack<>();
      for(int i=0;i<=n;i++)
      {
        int currHeight=i==n?0:h[i];
        while(!s.isEmpty()&&currHeight<h[s.peek()])
        {
            int top=s.pop();
            int width=s.isEmpty()?i:i-s.peek()-1;
            int area=h[top]*width;
            maxArea=Math.max(area,maxArea);
        }
        s.push(i);
      }
      return maxArea;  
    }
}
