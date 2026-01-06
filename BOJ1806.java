package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class BOJ1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] pSum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n;i ++) {
            pSum[i] = pSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int left = 1; int right = 1;
        int ans = 100001;
        while(left <= right && right <= n) {
            int total = pSum[right] - pSum[left - 1];
            if (total >= s) {
                ans = min(ans, right - left + 1);
                left += 1;
            } else {
                right += 1;
            }
        }

        System.out.print(ans == 100001 ? 0 : ans);
        br.close();
    }
}
