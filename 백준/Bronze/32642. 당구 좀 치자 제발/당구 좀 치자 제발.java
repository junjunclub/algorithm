import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] list = new long[n];

        for (int i = 0; i < n; i++) {
            list[i] = Long.parseLong(st.nextToken());
        }

        long anger = 0;
        long answer = 0;
        for (int i = 0; i < n; i++) {
            if (list[i] == 0) {
                anger -= 1;
            } else if (list[i] == 1) {
                anger += 1;
            }
//            System.out.println(list[i]);
            answer += anger;
        }

        System.out.println(answer);
    }
}
