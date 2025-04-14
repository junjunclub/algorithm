import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] list;
    static List<Integer> arr;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        arr = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            arr.add(list[i]-list[i-1]);
        }

        Collections.sort(arr);
        int answer = 0;
        for (int i = 0; i < N - K; i++) {
            answer += arr.get(i);
        }
        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }
}
