import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] list;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int s = 0;
        int e = 0;
        int oddCount = 0;
        int answer = 0;

        while (e < N) {
            // 홀수인 경우
            if (list[e] % 2 == 1) {
                oddCount++;
            }

            // 홀수 개수가 K 초과되면 s를 옮기며 조정
            while (oddCount > K) {
                if (list[s] % 2 == 1) {
                    oddCount--;
                }
                s++;
            }

            // 현재 구간의 짝수 개수: 전체 길이 - 홀수 개수
            answer = Math.max(answer, e - s + 1 - oddCount);
            e++;
        }

        System.out.println(answer);
    }


    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }
}
