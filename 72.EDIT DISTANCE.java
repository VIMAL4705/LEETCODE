class Solution 
{
    public int minDistance(String word1, String word2) 
    {
        int p=word1.length();
        int q=word2.length();
        int [][]memo=new int[p+1][q+1];
        for(int i=1;i<=q;i++)
        {
            memo[0][i]=i;
        }
        for(int j=1;j<=p;j++)
        {
            memo[j][0]=j;
        }
        for(int i=1;i<=p;i++)
        {
            for(int j=1;j<=q;j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
            {
                memo[i][j]=memo[i-1][j-1];
            }
            else
            {
                int insertion=memo[i][j-1];
                int deletion=memo[i-1][j];
                int replacement=memo[i-1][j-1];
                memo[i][j]=Math.min(Math.min(insertion,deletion),replacement)+1;
            }
            }
        }
        return memo[p][q];
    }
}
