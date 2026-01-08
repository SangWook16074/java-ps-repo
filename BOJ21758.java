package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21758 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] pSum = new int[n + 1];
        int[] arr = new int[n];
        int ans = 0;
        for (int i = 1; i <= n; i ++) {
            arr[i - 1] = Integer.parseInt(st.nextToken());
            pSum[i] = pSum[i - 1] + arr[i - 1];
        }

        for (int i = 2; i < n; i ++) {
            int total = pSum[n] - pSum[1] + pSum[n] - pSum[i] - arr[i - 1];
            ans = Math.max(ans, total);
        }

        for (int i = 2; i < n; i ++) {
            int total = pSum[n - 1] - pSum[0] + pSum[i - 1] - pSum[0] - arr[i - 1];
            ans = Math.max(ans, total);
        }

        for (int i = 2; i < n; i ++) {
            int total = pSum[i] - pSum[1] + pSum[n - 1] - pSum[i - 1];
            ans = Math.max(ans, total);
        }

        System.out.print(ans);

        br.close();
    }
}
