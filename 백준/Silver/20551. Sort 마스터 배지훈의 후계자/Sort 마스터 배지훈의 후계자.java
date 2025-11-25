import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N, M;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
            init();
        }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(br.readLine());
            binarySearch(n);
        }

        System.out.println(sb);
    }

    private static void binarySearch(int n) {
        int s = 0;
        int e = N;

        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] < n) s = mid + 1;
            else e = mid;
        }

        if (s < N && arr[s] == n) {
            sb.append(s).append("\n");
        } else {
            sb.append(-1).append("\n");
        }
    }
}
