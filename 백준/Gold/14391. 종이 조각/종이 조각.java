import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] board;
    public static void main(String[] args) throws Exception{
        init();
        solve();
        /**
         * 1. 비트 마스킹으로 가로, 세로를 구분
         * 2. 2*2 배열이라면 0000, 0001, 0010, 0011... 식으로 만들어준다.
         * 3. 현재 위치를 찾아서 & 연산으로 비교
         * 4. 값 갱신
         */
    }

    private static void solve() {
        int answer = 0;
        for (int bit = 0; bit < (1<<(m*n)); bit++) {
            // 보드판을 새로 만들어서 가로, 세로 모든 경우의 수를 센다
            int sumV = 0;
            // 가로일 때
            for (int i = 0; i < n; i++) {
                int order = 1;
                for (int j = m-1; j >= 0; j--) {
                    int now = i*m+j;
                    if ((bit & (1<<now)) != 0) {
                        sumV += order*board[i][j];
                        order *= 10;
                    } else {
                        order = 1;
                    }
                }
            }
            // 세로일 때
            for (int j = 0; j < m; j++) {
                int order = 1;
                for (int i = n-1; i >= 0; i--) {
                    int now = i*m+j;
                    if ((bit & (1<<now)) == 0) {
                        sumV += order*board[i][j];
                        order *= 10;
                    } else {
                        order = 1;
                    }
                }
            }
            answer = Math.max(answer, sumV);
        }
        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }


    }
}
