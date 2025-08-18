class Solution 
{
    public int numDecodings(String s) 
    {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) != '0') ? 1 : 0;

        for(int i = 2; i <= n; i++)
        {
            if(s.charAt(i-1) != '0')
            {
                dp[i] += dp[i-1];
            }
            int t = Integer.parseInt(s.substring(i-2, i));
            if(t >= 10 && t <= 26)  
            {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
