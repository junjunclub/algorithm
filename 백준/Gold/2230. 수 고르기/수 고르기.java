import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         * 1. 정렬
         * 2. 그 다음 순회하면서 이분탐색을 진행한다.
         */
    }

    private static void solve() {
        int start = 0;
        int end = 0;

        while (end < n) {
            if (arr[end] - arr[start] < m) {
                end++;
                continue;
            }

            if (arr[end] - arr[start] == m) {
                answer = m;
                break;
            }

            answer = Math.min(arr[end] - arr[start], answer);
            start++;
        }


        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
    }
}
