import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    static class Node {
        int r, c;
        public Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int R1, C1, nowR, nowC;
    static char[][] board;
    static boolean[][] ans;
    static char[] order;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {

        for (int i = 0; i < order.length; i++) {
            char o = order[i];

            if (o == 'W') {
                putWard(nowR, nowC);
            } else if (o == 'L') {
                nowC -= 1;
            } else if (o == 'R') {
                nowC += 1;
            } else if (o == 'U') {
                nowR -= 1;
            } else if (o == 'D') {
                nowR += 1;
            }
        }

        for (int i = 0; i < 4; i++) {
            int newR = nowR + dr[i];
            int newC = nowC + dc[i];

            if (newR < 0 || newC < 0 || newR >= R1 || newC >= C1) continue;
            ans[newR][newC] = true;
        }

        ans[nowR][nowC] = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R1; i++) {
            for (int j = 0; j < C1; j++) {
                if (ans[i][j]) {
                    sb.append('.');
                } else {
                    sb.append('#');
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void putWard(int r, int c) {
        Node n = new Node(r, c);
        Deque<Node> q = new ArrayDeque<>();
        q.add(n);
        ans[r][c] = true;


        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int newR = cur.r + dr[i];
                int newC = cur.c + dc[i];

                if (newR < 0 || newC < 0 || newR >= R1 || newC >= C1) continue;
                if (ans[newR][newC]) continue;
                if (board[newR][newC] == board[r][c]) {
                    q.add(new Node(newR, newC));
                    ans[newR][newC] = true;
                }
            }
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R1 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());

        board = new char[R1][C1];
        ans = new boolean[R1][C1];

        for (int i = 0; i < R1; i++) {
            board[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        nowR = Integer.parseInt(st.nextToken()) - 1;
        nowC = Integer.parseInt(st.nextToken()) - 1;

        String input = br.readLine();
        order = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            order[i] = input.charAt(i);
        }
    }
}
