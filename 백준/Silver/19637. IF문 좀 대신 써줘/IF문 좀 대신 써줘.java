import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static String[][] list;
    static int N, M;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = N-1;
            int mid = (start + end) / 2;
            int v = Integer.parseInt(br.readLine());
            while (start <= end) {
                mid = (start + end) / 2;
                int num = Integer.parseInt(list[mid][1]);
                // 입력받은 값이 현재 값보다 작은 경우
                if (v <= num) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            sb.append(list[start][0]).append("\n");
        }
        System.out.println(sb);
    }

    private static void init() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new String[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = st.nextToken();
            list[i][1] = st.nextToken();
        }
    }
}
