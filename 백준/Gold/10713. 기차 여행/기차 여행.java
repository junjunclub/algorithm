import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, sum;
    public static void main(String[] args) throws Exception{
            init();
    }
    
    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start, end;
        for (int i = 1; i < M; i++) {
            start = arr[i - 1];
            end = arr[i];

            if (start > end) {
                int temp = start;
                start = end;
                end = temp;
            }
            sum[start]++;
            sum[end]--;
        }

        for (int i = 1; i <= N; i++) {
            sum[i] += sum[i - 1];
        }

//        System.out.println(Arrays.toString(sum));

        int ans = 0;

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());

            int minV = Math.min(n1 * sum[i], n3 + (n2 * sum[i]));

            ans += minV;
        }

        System.out.println(ans);
    }
}