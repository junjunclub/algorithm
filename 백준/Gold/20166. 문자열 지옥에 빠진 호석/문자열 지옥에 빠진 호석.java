import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static int N, M, K;
    static char[][] board;
    static String[] words;
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    static Map<String, Integer> map;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        //전처리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(board[i][j]);
                addWord(i, j, 1, sb);
            }
        }

        for (int i = 0; i < K; i++) {
            System.out.println(map.get(words[i]));
        }
    }

    private static void addWord(int r, int c, int len, StringBuilder sb) {
        if (len == words[0].length()) {
            if (map.containsKey(sb.toString())) {
                map.put(sb.toString(), map.get(sb.toString()) + 1);
            }
            return;
        }

        // 8방향 탐색
        for (int d = 0; d < 8; d++) {
            int nr = (r + dr[d] + N) % N;
            int nc = (c + dc[d] + M) % M;
            sb.append(board[nr][nc]);
            addWord(nr, nc, len + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static void init() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        words = new String[K];
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < K; i++) {
            words[i] = br.readLine();
            map.put(words[i], 0);
        }
    }
}

