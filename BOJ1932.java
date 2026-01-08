package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1932 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i ++ ) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j ++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i ++) {
            for (int j = 0; j <= i; j ++) {
                int left = j - 1; int right = j;
                if (left != -1) {
                    dp[i][j] = Math.max(dp[i][j], arr[i][j] + dp[i - 1][left]);
                }
                if (right != i) {
                    dp[i][j] = Math.max(dp[i][j], arr[i][j] + dp[i - 1][right]);
                }
            }
        }
        int max = Arrays.stream(dp[n - 1]).max().getAsInt();
        System.out.print(max);
        br.close();

    }
}
