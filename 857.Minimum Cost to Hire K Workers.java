class Solution {
    class Pair implements Comparable<Pair> {
        double r;
        int q;
        
        Pair(double r, int q) {
            this.r = r;
            this.q = q;
        }
        
        public int compareTo(Pair p) {
            return Double.compare(this.r, p.r);
        }
    }
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double ans = Double.MAX_VALUE;
        double curr_sum = 0;
        List<Pair> workers = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            workers.add(new Pair(wage[i] / (double) quality[i], quality[i]));
        }
        
        Collections.sort(workers);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (Pair w : workers) {
            double ratio = w.r;
            int qual = w.q;
            curr_sum += qual;
            pq.add(qual);
            
            if (pq.size() > k) {
                curr_sum -= pq.poll();
            }
            
            if (pq.size() == k) {
                ans = Math.min(ans, curr_sum * ratio);
            }
        }
        return ans;
    }
}
