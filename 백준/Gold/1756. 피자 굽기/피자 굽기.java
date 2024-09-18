import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] oven = new int[d];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < d; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
            if (i != 0 && oven[i-1] < oven[i]) {
                oven[i] = oven[i-1];
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] pizza = new int[m];
        for (int i = 0; i < m; i++) {
            pizza[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[d];
        int idx = d-1, result = 0, cnt = 0;

        for (int i = 0; i < pizza.length; i++) {
            // 피자 반죽이 오븐 지름보다 더 큰 경우
            while (idx >= 0) {
                if (oven[idx] >= pizza[i]) {
                    visited[idx] = true;
                    result = idx + 1;
                    cnt++;
                    idx--;
                    break;
                }
                idx--;
            }
        }
        if (cnt != m) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}