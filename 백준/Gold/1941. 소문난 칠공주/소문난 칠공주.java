import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int[] checked;
    static boolean[] visited;
    static int ans = 0;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         *  25C7 만들기
         *  만든 조건 순회하면서 연결돼있는지, 임도연파가 4명 이상이면 안봄
         */
    }

    private static void solve() {
        backTracking(0, 0, 0);
        System.out.println(ans);
    }

    private static void backTracking(int start, int cnt, int syCnt) {
        if (syCnt >= 4) {
            return;
        }

        if (cnt == 7) {
            bfs();
            return;
        }

        for (int i = start; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;
            checked[cnt] = i;
            if (board[r][c] == 'Y') {
                backTracking(i+1, cnt+1, syCnt+1);
            } else {
                backTracking(i+1, cnt+1, syCnt);
            }
        }
    }

    private static void bfs() {
        visited = new boolean[7];
        Queue<int[]> q = new LinkedList<>();
        int value = checked[0];
        int r = value / 5;
        int c = value % 5;
        q.add(new int[] {r, c});
        for (int i = 0; i < 7; i++) {
            if (checked[i] == value) {
                visited[i] = true;
                break;
            }
        }
        int num = 1;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int curR = temp[0];
            int curC = temp[1];

            for (int i = 0; i < 4; i++) {
                int newR = curR + dr[i];
                int newC = curC + dc[i];

                if (0 > newR || newR >= 5 || 0 > newC || newC >= 5) continue;

                int v = 5 * newR + newC;

                for (int j = 0; j < 7; j++) {
                    if (!visited[j] && checked[j] == v) {
                        q.add(new int[] {newR, newC});
                        visited[j] = true;
                        num++;
                    }
                }
            }
        }
        if (num == 7) ans++;
    }


    private static void init() throws Exception{
        board = new char[5][5];
        checked = new int[7];
        visited = new boolean[7];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            board[i] = st.nextToken().toCharArray();
        }
    }
}
