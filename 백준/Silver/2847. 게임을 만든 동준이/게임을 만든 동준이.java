import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    static int N;
    static int[] arr1, arr2;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int answer = 0;
        for (int i = N-1; i >= 1; i--) {
            // 전 값이 더 크다면
            if (arr1[i] <= arr1[i-1]) {
                answer += arr1[i-1] - arr1[i] + 1;
                arr1[i-1] = arr1[i] - 1;
            }
        }

        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr1 = new int[N];
        arr2 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }
    }
}
