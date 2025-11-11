class Solution {
    public boolean isSubsequence(String str1, String str2) {

        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == str1.length();
    }
}
