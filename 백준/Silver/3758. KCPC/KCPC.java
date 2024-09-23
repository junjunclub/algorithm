import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Info> list;
    static StringBuilder sb = new StringBuilder();

    static class Info implements Comparable<Info> {
        int id, score, cnt, time;

        public Info(int id, int score, int cnt, int time) {
            this.id = id;
            this.score = score;
            this.cnt = cnt;
            this.time = time;
        }

        @Override
        public int compareTo(Info i) {
            if (this.score == i.score) {
                if (this.cnt == i.cnt) {
                    return this.time - i.time;
                }
                return this.cnt - i.cnt;
            }
            return i.score - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] logs = new int[m][3];

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                // a 팀 ID, b 문제 번호, c 획득 점수
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                logs[j][0] = a;
                logs[j][1] = b;
                logs[j][2] = c;
            }

            int[][] saveScore = new int[n+1][k+1];
            int[] cntSubmit = new int[n+1];
            int[] time = new int[n+1];

            for (int j = 0; j < m; j++) {
                int nowId = logs[j][0];
                int nowCnt = logs[j][1];
                int nowScore = logs[j][2];

                cntSubmit[nowId]++;
                time[nowId] = j;

                if (nowScore > saveScore[nowId][nowCnt]) {
                    saveScore[nowId][nowCnt] = nowScore;
                }
            }

            list = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                int sum = 0;
                for (int l = 0; l <= k; l++) {
                    sum += saveScore[j][l];
                }
                list.add(new Info(j, sum, cntSubmit[j], time[j]));
            }
            Collections.sort(list);

            for (int j = 0; j < n; j++) {
                if (list.get(j).id == t) {
                    sb.append((j + 1)).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}