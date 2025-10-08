import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    public static void main(String[] args) throws Exception{
            init();
        }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
//            int[] sum = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int start = 0;
            int end = M;

            int ans = 0;

            int v = 0;

            for (int j = start; j < end; j++) {
                v += arr[j];
            }

            while (start != N) {
                if (v < K) {
                    ans++;
                }

                if (M == N) break;

                v -= arr[start % N];
                v += arr[end % N];
                start++;
                end++;
            }

            System.out.println(ans);
        }
    }
}