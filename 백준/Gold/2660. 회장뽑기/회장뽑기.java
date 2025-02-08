import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] list;
    static final int INF = 987654321;
    static int[] answer;
    static StringBuilder sb1, sb2;
    public static void main(String[] args) throws Exception {
        init();
        solve();
        /**
         * 1. dfs 돌리기
         */
    }

    private static void solve() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (list[i][j] > list[i][k] + list[k][j]) {
                        list[i][j] = list[i][k] + list[k][j];
                    }
                }
            }
        }

        answer = new int[n + 1];
        int result = INF;

        for (int i = 1; i <= n; i++) {
            int score = 0;
            for (int j = 1; j <= n; j++) {
                if (list[i][j] != INF) {
                    score = Math.max(score, list[i][j]);
                }
            }
            answer[i] = score;
            result = Math.min(result, score);
        }

        sb1 = new StringBuilder();
        sb2 = new StringBuilder();
        sb1.append(result).append(" ");

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (answer[i] == result) {
                cnt++;
                sb2.append(i).append(" ");
            }
        }
        sb1.append(cnt);

        System.out.println(sb1);
        System.out.println(sb2);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i != j) {
                    list[i][j] = INF;
                }
            }
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (s == -1 && e == -1) {
                break;
            }

            list[s][e] = list[e][s] = 1;
        }
    }
}
