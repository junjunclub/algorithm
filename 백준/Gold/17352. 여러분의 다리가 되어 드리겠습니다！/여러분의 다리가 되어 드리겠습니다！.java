import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {

    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }
        StringTokenizer st;
        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            union(start, end);
        }

        for (int i = 1; i <= N; i++) {
            if (arr[i] == i) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void union(int start, int end) {
        int x = find(start);
        int y = find(end);

        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }

        if (x != y) {
            arr[y] = x;
        }
    }

    private static int find(int start) {
        if (start != arr[start]) {
            arr[start] = find(arr[start]);
        }
        return arr[start];
    }
}
