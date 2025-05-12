import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, res;
    static List<Integer>[] emp;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        praise(1, 0);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void praise(int start, int parent) {
        res[start] += res[parent] + arr[start];

        for (int next : emp[start]) {
            praise(next, start);
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        res = new int[N + 1];
        emp = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            emp[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (i >= 2) {
                emp[num].add(i);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int em = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[em] += v;
        }
    }
}
