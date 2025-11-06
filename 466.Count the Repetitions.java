class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) return 0;

        int s1cnt = 0, s2cnt = 0, index = 0;
        int[] recall = new int[s2.length()];
        int[] count = new int[s2.length()];

        while (true) {
            s1cnt++;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(index)) {
                    index++;
                }
                if (index == s2.length()) {
                    s2cnt++;
                    index = 0;
                }
            }
            if (s1cnt == n1) {
                return s2cnt / n2;
            }

            if (recall[index] != 0) {
                int s1cntPrime = recall[index];
                int s2cntPrime = count[index];

                int loop1 = s1cnt - s1cntPrime;
                int loop2 = s2cnt - s2cntPrime;
                int rest = n1 - s1cntPrime;
                int answer = s2cntPrime + (rest / loop1) * loop2;

                int rest2 = rest % loop1;
                for (int i = 0; i < rest2; i++) {
                    for (int j = 0; j < s1.length(); j++) {
                        if (s1.charAt(j) == s2.charAt(index)) {
                            index++;
                        }
                        if (index == s2.length()) {
                            answer++;
                            index = 0;
                        }
                    }
                }
                return answer / n2;
            } else {
                recall[index] = s1cnt;
                count[index] = s2cnt;
            }
        }
    }
}
