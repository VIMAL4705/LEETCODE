class Solution {

    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        int rows = forest.size();
        int cols = forest.get(0).size();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int height = forest.get(r).get(c);
                if (height > 1) {
                    trees.add(new int[]{height, r, c});
                }
            }
        }

        trees.sort(Comparator.comparingInt(a -> a[0]));

        int totalSteps = 0;
        int sr = 0, sc = 0;

        for (int[] t : trees) {
            int tr = t[1];
            int tc = t[2];
            int steps = bfs(forest, sr, sc, tr, tc);
            if (steps == -1) return -1;
            totalSteps += steps;
            sr = tr;
            sc = tc;
        }

        return totalSteps;
    }

    private int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        if (sr == tr && sc == tc) return 0;

        int rows = forest.size();
        int cols = forest.get(0).size();

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        int steps = 0;
        int[][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1} };

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] d : dirs) {
                    int nr = cur[0] + d[0];
                    int nc = cur[1] + d[1];

                    if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;
                    if (visited[nr][nc] || forest.get(nr).get(nc) == 0) continue;
                    if (nr == tr && nc == tc) return steps;

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}
