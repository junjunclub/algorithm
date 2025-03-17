import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n, cnt, s, e, answer;
    public static void main(String[] args) throws Exception{
        init();
        solve();

        System.out.println(answer);

        /**
         * 1. 시작 0, 끝 n-1번째 값을 둔다.
         * 2. 더 작은 값을 안쪽으로 옮겨가며 갱신?
         */
    }

    private static void solve() {
        while (s <= e) {
            int minV = Math.min(arr[s], arr[e]);
            int temp = cnt * minV;
            answer = Math.max(temp, answer);
            // 만약 뒤에 있는 값이 더 크다면
            if (arr[s] < arr[e]) {
                s++;
                cnt--;
            } else if (arr[s] > arr[e]) {
                e--;
                cnt--;
            } else {
                s++;
                e--;
                cnt -= 2;
            }
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        cnt = n-2;
        s = 0;
        e = n-1;

        answer = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
