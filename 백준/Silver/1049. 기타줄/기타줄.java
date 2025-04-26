import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception{
        init();
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int minPack = Integer.MAX_VALUE;
        int minEach = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int each = Integer.parseInt(st.nextToken());

            minPack = Math.min(pack, minPack);
            minEach = Math.min(each, minEach);
        }
        int answer = 0;
        if (minEach * 6 <= minPack) {
            answer += minEach * N;
        } else {
            int temp = N / 6;
            answer += temp * minPack;
            if (N % 6 * minEach <= minPack) {
                answer += minEach * (N % 6);
            } else {
                answer += minPack;
            }
        }

        System.out.println(answer);
    }
}
