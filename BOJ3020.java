package ps;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] arr = new int[h];
        for (int i = 0; i < n; i ++) {
            int l = Integer.parseInt(br.readLine());
            if (i % 2 == 1) {
                arr[0] += 1;
                arr[l] -= 1;
            } else {
                arr[h - l] += 1;
            }
        }
        for (int i = 1; i < h; i ++) {
            arr[i] += arr[i - 1];
        }

        int minV = Arrays.stream(arr).min().getAsInt();
        int ans = 0;
        for (int i = 0; i < h; i ++) {
            if (arr[i] == minV) ans ++;
        }
        bw.append(String.format("%s %s", minV, ans));
        bw.flush();
        br.close();
        bw.close();
    }
}
