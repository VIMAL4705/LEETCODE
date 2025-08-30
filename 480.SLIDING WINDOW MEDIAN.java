class Solution 
{
    private java.util.PriorityQueue<Integer> small = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
    private java.util.PriorityQueue<Integer> large = new java.util.PriorityQueue<>(); 
    private java.util.Map<Integer, Integer> delayed = new java.util.HashMap<>();
    private int smallSize = 0, largeSize = 0; 
    private void prune(java.util.PriorityQueue<Integer> heap) 
    {
        while (!heap.isEmpty()) 
        {
            int x = heap.peek();
            Integer cnt = delayed.get(x);
            if (cnt == null || cnt == 0) break;
            heap.poll();
            if (cnt == 1) delayed.remove(x);
            else delayed.put(x, cnt - 1);
        }
    }

    private void balance()
     {
        if (smallSize > largeSize + 1) 
        {
            large.add(small.poll());
            smallSize--;
            largeSize++;
            prune(small);
        } 
        else if (smallSize < largeSize) 
        {
            small.add(large.poll());
            largeSize--;
            smallSize++;
            prune(large);
        }
    }

    private void add(int num) 
    {
        if (small.isEmpty() || num <= small.peek()) 
        {
            small.add(num);
            smallSize++;
        } 
        else 
        {
            large.add(num);
            largeSize++;
        }
        balance();
    }

    private void remove(int num)
     {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
        if (!small.isEmpty() && num <= small.peek()) 
        {
            smallSize--;
            if (!small.isEmpty() && num == small.peek()) prune(small);
        } 
        else 
        {
            largeSize--;
            if (!large.isEmpty() && num == large.peek()) prune(large);
        }
        balance();
    }

    public double[] medianSlidingWindow(int[] nums, int k) 
    {
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        for (int i = 0; i < n; i++) 
        {
            add(nums[i]);
            if (i >= k - 1) 
            {
                prune(small);
                prune(large);
                if ((k & 1) == 1) ans[i - k + 1] = small.peek();
                else ans[i - k + 1] = ((long) small.peek() + (long) large.peek()) / 2.0;
                remove(nums[i - k + 1]);
            }
        }
        return ans;
    }
}
