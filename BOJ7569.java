package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int [][][] graph = new int [h][n][m];
        for (int x = 0; x < h; x ++) {
            for (int y = 0; y < n; y ++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int z = 0; z < m; z ++) {
                    graph[x][y][z] = Integer.parseInt(st.nextToken());
                }
            }
        }
        Queue<int []> queue = new LinkedList<>();
        for (int x = 0; x < h; x ++) {
            for (int y = 0; y < n; y ++) {
                for (int z = 0; z < m; z ++) {
                    if (graph[x][y][z] == 1) {
                        queue.add(new int[]{x, y, z});
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int[] dx = {1, 0, -1, 0, 0, 0};
            int[] dy = {0, 1, 0, -1, 0, 0};
            int[] dz = {0, 0, 0,  0, - 1, 1};
            int x = node[0]; int y = node[1]; int z = node[2];
            for (int i = 0; i < 6; i ++) {
                int nx = x + dx[i]; int ny = y + dy[i]; int nz = z + dz[i];
                if (nx < 0 || nx >= h || ny < 0 || ny >= n || nz < 0 || nz >= m) {continue;}
                if (graph[nx][ny][nz] == 0) {
                    graph[nx][ny][nz] = graph[x][y][z] + 1;
                    queue.add(new int[] {nx, ny, nz});
                }
            }
        }
        int ans = 0;
        boolean flag = false;
        for (int x = 0; x < h; x ++) {
            for (int y = 0; y < n; y ++) {
                for (int z = 0; z < m; z ++) {
                    if (graph[x][y][z] == 0) {
                        flag = true;

                    }

                    ans = Math.max(ans, graph[x][y][z] - 1);
                }
            }
        }
        System.out.print(flag ? -1 : ans);
    }
}
