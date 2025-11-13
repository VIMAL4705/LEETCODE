import java.util.*;

class Solution {
    HashMap<Integer, Integer> map;
    int zeros;
    Random rand;
    int m, n;

    public Solution(int m, int n) {
        map = new HashMap<>();
        zeros = m * n;
        rand = new Random();
        this.m = m;
        this.n = n;
    }

    public int[] flip() {
        int r = rand.nextInt(zeros);
        int actual = map.getOrDefault(r, r);
        int[] ret = new int[]{actual / n, actual % n};
        map.put(r, map.getOrDefault(zeros - 1, zeros - 1));
        zeros--;
        return ret;
    }

    public void reset() {
        map.clear();
        zeros = m * n;
    }
}
