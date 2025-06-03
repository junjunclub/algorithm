import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            answer[i] = arr[i] + arr[(N * 2) - i - 1];
        }
        Arrays.sort(answer);
        System.out.println(answer[0]);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N*2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }
}
