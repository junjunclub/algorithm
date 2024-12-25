import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int maxV;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        /**
         * 술래잡기와 비슷한듯 함
         * 포만감의 1/2 값도 방문처리하고, queue에 넣어서 bfs 돌리면 될 것같다..?
         * 다만 최대 1번 물을 마실 수 있어서, 조건을 달아줘야 할 것 같음
         * 우선 a, b로 bfs 돌리고 그 후 1/2 한 값 방문처리하고 다시 돌려줘야하나?
         * 그리고 방문한 값중에 가장 큰 값을 출력
         */
        visited = new boolean[t+1];
        maxV = 0;
        dfs(0, t, a, b, false);
        System.out.println(maxV);
    }

    private static void dfs(int now, int end, int aV, int bV, boolean flag) {
        if (visited[now]) {
            return;
        }

        visited[now] = true;
        maxV = Math.max(now, maxV);

        int temp = now + aV;
        if (temp >= 0 && temp <= end && !visited[temp]) {
            dfs(temp, end, aV, bV, flag);
            if (!flag) {
                dfs(temp/2, end, aV, bV, true);
            }
        }

        temp = now + bV;
        if (temp >= 0 && temp <= end && !visited[temp]) {
            dfs(temp, end, aV, bV, flag);
            if (!flag) {
                dfs(temp/2, end, aV, bV, true);
            }
        }
    }
}
