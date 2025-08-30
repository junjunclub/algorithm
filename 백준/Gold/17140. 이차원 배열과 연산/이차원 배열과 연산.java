import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Number implements Comparable<Number>{
        int v, cnt;
        public Number (int v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }

        @Override
        public int compareTo (Number n) {
            if (this.cnt != n.cnt) return Integer.compare(this.cnt, n.cnt);
            return Integer.compare(this.v, n.v);
        }
    }

    static int r, c, k;
    static int[][] board;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int row = 3;
        int col = 3;

        for (int t = 0; t <= 100; t++) {
            if (r < row && c < col && board[r][c] == k) {
                System.out.println(t);
                return;
            }

            int[][] temp = new int[101][101];

            if (row >= col) { // R 연산
                int newCol = 0;
                for (int u = 0; u < row; u++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int v = 0; v < col; v++) {
                        if (board[u][v] != 0) {
                            map.put(board[u][v], map.getOrDefault(board[u][v], 0) + 1);
                        }
                    }
                    List<Number> list = new ArrayList<>();
                    for (Integer n : map.keySet()) {
                        list.add(new Number(n, map.get(n)));
                    }
                    Collections.sort(list);

                    int idx = 0;
                    for (Number n : list) {
                        if (idx >= 100) break;
                        temp[u][idx++] = n.v;
                        if (idx >= 100) break;
                        temp[u][idx++] = n.cnt;
                    }
                    newCol = Math.max(newCol, idx);
                }
                col = newCol;
            } else { // C 연산
                int newRow = 0;
                for (int u = 0; u < col; u++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int v = 0; v < row; v++) {
                        if (board[v][u] != 0) {
                            map.put(board[v][u], map.getOrDefault(board[v][u], 0) + 1);
                        }
                    }
                    List<Number> list = new ArrayList<>();
                    for (Integer n : map.keySet()) {
                        list.add(new Number(n, map.get(n)));
                    }
                    Collections.sort(list);

                    int idx = 0;
                    for (Number n : list) {
                        if (idx >= 100) break;
                        temp[idx++][u] = n.v;
                        if (idx >= 100) break;
                        temp[idx++][u] = n.cnt;
                    }
                    newRow = Math.max(newRow, idx);
                }
                row = newRow;
            }
            board = temp;
        }
        System.out.println(-1);
    }


    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        board = new int[101][101];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
