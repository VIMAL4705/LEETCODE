import java.util.*;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }
        return dfs(bottom, map);
    }

    private boolean dfs(String row, Map<String, List<Character>> map) {
        if (row.length() == 1) return true;
        List<String> nextRows = new ArrayList<>();
        backtrackBuild(row, 0, new StringBuilder(), nextRows, map);
        for (String nr : nextRows) {
            if (dfs(nr, map)) return true;
        }
        return false;
    }

    private void backtrackBuild(String row, int idx, StringBuilder cur, List<String> nextRows, Map<String, List<Character>> map) {
        if (idx == row.length() - 1) {
            nextRows.add(cur.toString());
            return;
        }
        String pair = row.substring(idx, idx + 2);
        List<Character> opts = map.get(pair);
        if (opts == null) return;
        for (char c : opts) {
            cur.append(c);
            backtrackBuild(row, idx + 1, cur, nextRows, map);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
