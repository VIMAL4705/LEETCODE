class Solution 
{
    public boolean canJump(int[] nums) 
    {
        int stepsLeft = nums[0];
        
        for (int i = 1; i < nums.length; i++) 
        {
            stepsLeft--; 
            
            if (stepsLeft < 0) return false; 
    
            if (nums[i] > stepsLeft) 
            {
                stepsLeft = nums[i];
            }
        }
        
        return true; 
    }
}
