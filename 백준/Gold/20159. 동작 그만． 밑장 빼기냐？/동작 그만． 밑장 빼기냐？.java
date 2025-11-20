import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr1, arr2;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int res = arr1[N / 2];

        for (int i = 0; i < N; i++) {
            int temp;
            if (i % 2 == 0) {
                temp = arr1[i / 2 + 1] + (arr2[N / 2 - 1] - arr2[i / 2]);
            } else {
                temp = arr1[i / 2] + (arr2[N / 2] - arr2[i / 2]);
            }

            res = Math.max(res, temp);
        }
        System.out.println(res);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr1 = new int[N / 2 + 1];
        arr2 = new int[N / 2 + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                arr1[i / 2 + 1] = arr1[i / 2] + Integer.parseInt(st.nextToken());
            } else {
                arr2[i / 2 + 1] = arr2[i / 2] + Integer.parseInt(st.nextToken());
            }
        }
    }
}
