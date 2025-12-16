import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[] arr;
    static int[][][] dist;
    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve() {
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        recur(a, b, c, 0);

        System.out.println(ans);
    }

    private static void recur(int a, int b, int c, int cnt) {
        int tempA = Math.max(0, a);
        int tempB = Math.max(0 ,b);
        int tempC = Math.max(0, c);

        if (tempA == 0 && tempB == 0 && tempC == 0) {
            ans = Math.min(cnt, ans);
            return;
        }

        int[] tempArr = new int[]{tempA, tempB, tempC};

        Arrays.sort(tempArr);

        tempA = tempArr[2];
        tempB = tempArr[1];
        tempC = tempArr[0];

        if (cnt >= ans) return;

        if (dist[tempA][tempB][tempC] != 0 && dist[tempA][tempB][tempC] <= cnt) return;
        dist[tempA][tempB][tempC] = cnt;

        recur(tempA - 9, tempB - 3, tempC - 1, cnt + 1);
        recur(tempA - 9, tempB - 1, tempC - 3, cnt + 1);
        recur(tempA - 3, tempB - 9, tempC - 1, cnt + 1);
        recur(tempA - 3, tempB - 1, tempC - 9, cnt + 1);
        recur(tempA - 1, tempB - 3, tempC - 9, cnt + 1);
        recur(tempA - 1, tempB - 9, tempC - 3, cnt + 1);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[3];
        dist = new int[61][61][61];
        ans = Integer.MAX_VALUE;


        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}