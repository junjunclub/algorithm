import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] list = new int[100001];
    static int n;
    static int k;
    static int minV = 100001;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0+"\n"+1);
            return;
        }

        bfs();

        System.out.println(minV+"\n"+cnt);

    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(n);
        list[n] = 1;

        while (!q.isEmpty()) {
            int v = q.poll();

            if (list[v] > minV) return;

            for (int i = 0; i < 3; i++) {
                int nextV;
                if (i == 0) {
                    nextV = v + 1;
                } else if (i == 1) {
                    nextV = v - 1;
                } else {
                    nextV = 2 * v;
                }

                if (0 > nextV || 100000 < nextV) continue;

                if (nextV == k) {
                    minV = list[v];
                    cnt++;
                }

                if (list[nextV] == 0 || list[nextV] == list[v]+1) {
                    q.add(nextV);
                    list[nextV] = list[v] + 1;
                }
            }
        }
    }
}
