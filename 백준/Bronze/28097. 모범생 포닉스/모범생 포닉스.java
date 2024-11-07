import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (i != n-1) {
                answer += list[i];
                answer += 8;
            } else {
                answer += list[i];
            }
        }

        sb.append(answer / 24).append(" ").append(answer % 24);

        System.out.println(sb);
    }
}
