public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        return helper(s, k, 0, s.length());
    }

    private int helper(String s, int k, int start, int end) {
        if (end - start < k) return 0;

        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int mid = start; mid < end; mid++) {
            if (count[s.charAt(mid) - 'a'] < k) {
                int next = mid + 1;
                while (next < end && count[s.charAt(next) - 'a'] < k) next++;
                return Math.max(helper(s, k, start, mid), helper(s, k, next, end));
            }
        }

        // Every character in s[start:end) appears at least k times
        return end - start;
    }
}
