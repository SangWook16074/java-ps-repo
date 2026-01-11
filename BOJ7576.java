package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int ans = 0;

        st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        for (int x = 0; x < n; x ++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int y = 0; y < m; y ++) {
                graph[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int x = 0; x < n; x ++) {
            for (int y = 0; y < m; y ++) {
                if (graph[x][y] == 1) {
                    int[] node = new int[] {x, y};
                    queue.add(node);
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            int[] next = queue.poll();
            int x = next[0]; int y = next[1];
            for (int i = 0; i < 4; i ++) {
                int nx = x + dx[i]; int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {continue;}
                if (graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[x][y] + 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        int[] result = Arrays.stream(graph).flatMapToInt(Arrays::stream).toArray();
        System.out.print(Arrays.stream(result).anyMatch(value -> value == 0) ? -1 : Arrays.stream(result).max().getAsInt() - 1);

    }
}
