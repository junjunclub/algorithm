import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int R, C, count;
    static char[][] board;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int s = 0;
        int e = R - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (check(mid)) {
                s = mid + 1;
                count = s;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(count);
    }

    private static boolean check(int mid) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < C; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = mid + 1; j < R; j++) {
                sb.append(board[j][i]);
            }
            if (set.contains(sb.toString())) {
                return false;
            } else {
                set.add(sb.toString());
            }
        }
        return true;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        count = 0;

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
    }
}
