import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int[][] id = new int[m][n];
        int sr = 0, sc = 0, cnt = 0;

        for (int i = 0; i < m; i++) {
            Arrays.fill(id[i], -1);
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    sr = i;
                    sc = j;
                } else if (c == 'L') {
                    id[i][j] = cnt++;
                }
            }
        }

        if (cnt == 0) return 0;

        boolean[][][][] vis =
            new boolean[m][n][energy + 1][1 << cnt];

        Queue<int[]> q = new LinkedList<>();

        int startMask = (1 << cnt) - 1;
        q.add(new int[]{sr, sc, energy, startMask});
        vis[sr][sc][energy][startMask] = true;

        int[] d = {-1, 0, 1, 0, -1};
        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();

                int r = cur[0], c = cur[1];
                int e = cur[2], mask = cur[3];

                if (mask == 0) return ans;
                if (e == 0) continue;

                for (int k = 0; k < 4; k++) {
                    int nr = r + d[k];
                    int nc = c + d[k + 1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                        continue;

                    if (classroom[nr].charAt(nc) == 'X')
                        continue;

                    int ne = e - 1;
                    int nm = mask;

                    if (classroom[nr].charAt(nc) == 'R')
                        ne = energy;

                    if (classroom[nr].charAt(nc) == 'L')
                        nm &= ~(1 << id[nr][nc]);

                    if (!vis[nr][nc][ne][nm]) {
                        vis[nr][nc][ne][nm] = true;
                        q.add(new int[]{nr, nc, ne, nm});
                    }
                }
            }

            ans++;
        }

        return -1;
    }
}