class Solution {

    public int minStickers(String[] stickers, String target) {

        List<String> helping = new ArrayList<>();

        boolean[] needs = new boolean[128];
        char[] cs = target.toCharArray();
        for (char c : cs)
            needs[c] = true;

        for (String str : stickers) {
            String brief = helps(str, needs);
            if (brief.length() != 0)
                helping.add(str);
        }

        int[] dp = new int[1 << cs.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i + 1 != dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE)
                continue;

            for (String word : helping) {
                int next = i;
                for (int j = 0; j != word.length(); j++) {
                    final char ch = word.charAt(j);
                    for (int k = 0; k != cs.length; k++) {
                        if (ch != cs[k] || (next & (1 << k)) != 0)
                            continue;
                        next |= (1 << k);
                        break;
                    }
                }
                dp[next] = Math.min(dp[next], dp[i] + 1);
            }
        }

        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }

    private String helps(String str, boolean[] needs) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (needs[c])
                sb.append(c);
        }
        return sb.toString();
    }
}
