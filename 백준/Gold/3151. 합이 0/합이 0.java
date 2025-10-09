import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        init();
        solve();
        /**
         1. for문을 2번 돌려서 그게 map안에 있으면... 더해주기 로 풀려고 했는데 중복된 값 처리가 적절하지 않았음.

         2. for문을 한번 돌면서, left, right를 정한 후 이분탐색으로 가능한 값들을 확인하고 left right 값을 조정해주면 된다.
         */
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    private static void solve() {
        long ans = 0;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    if (arr[left] == arr[right]) {
                        int count = right - left + 1;
                        ans += (long) count * (count - 1) / 2;
                        break;
                    }
                    int leftCnt = 1;
                    int rightCnt = 1;
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        left++;
                        leftCnt++;
                    }
                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        right--;
                        rightCnt++;
                    }
                    ans += (long) leftCnt * rightCnt;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(ans);
    }
}
