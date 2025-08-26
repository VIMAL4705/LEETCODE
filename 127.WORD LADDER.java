class Solution 
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        if (!wordList.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);

        beginSet.add(beginWord);
        endSet.add(endWord);

        return bfs(beginSet, endSet, wordSet, 1);
    }

    private int bfs(Set<String> beginSet, Set<String> endSet, Set<String> wordSet, int distance) 
    {
        if (beginSet.isEmpty()) return 0;

        if (beginSet.size() > endSet.size()) 
        {
            return bfs(endSet, beginSet, wordSet, distance);
        }

        Set<String> reachableSet = new HashSet<>();
        wordSet.removeAll(beginSet);

        for (String word : beginSet) 
        {
            char[] charArray = word.toCharArray();
            for (int pos = 0; pos < charArray.length; pos++) 
            {
                char originalChar = charArray[pos];
                for (char c = 'a'; c <= 'z'; c++) 
                {
                    if (c == originalChar) continue;

                    charArray[pos] = c;
                    String newWord = new String(charArray);

                    if (endSet.contains(newWord)) 
                    {
                        return distance + 1;
                    }

                    if (wordSet.contains(newWord)) 
                    {
                        reachableSet.add(newWord);
                    }
                }
                charArray[pos] = originalChar;
            }
        }

        return bfs(reachableSet, endSet, wordSet, distance + 1);
    }
}
