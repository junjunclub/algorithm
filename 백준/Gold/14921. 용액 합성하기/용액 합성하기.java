import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, answer;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int left = 0;
        int right = n-1;

        while (left < right) {
            int temp = arr[left] + arr[right];

            if (Math.abs(temp) < Math.abs(answer)) {
                answer = temp;
            }

            if (temp < 0) {
                left++;
            } else if (temp > 0) {
                right--;
            } else {
                break;
            }
        }

        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }
}
