import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            double tall = 0;
            List<String> answer = new ArrayList<>();

            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                double b = Double.parseDouble(st.nextToken());
                // 최댓값 일 때
                if (b >= tall) {
                    if (b > tall) {
                        // 최댓값이 갱신될 때
                        answer = new ArrayList<>();
                    }
                    answer.add(a);
                    tall = b;
                }
            }
            for (String s : answer) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
