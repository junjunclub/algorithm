import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, T;
        public static void main(String[] args) throws Exception{
            init();
        }

        private static void init() throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < T; i++) {
                N = Integer.parseInt(br.readLine());
                int maxV = -1;
                int v = 0;
                int winner = -1;
                boolean flag = true;
                for (int j = 1; j <= N; j++) {
                    int num = Integer.parseInt(br.readLine());
                    v += num;
                    if (num > maxV) {
                        maxV = num;
                        winner = j;
                        flag = true;
                    } else if (num == maxV) {
                        flag = false;
                    }
                }

                if (flag) {
                    if (v / 2 >= maxV) {
                        sb.append("minority winner ").append(winner).append("\n");
                    } else {
                        sb.append("majority winner ").append(winner).append("\n");
                    }
                } else {
                    sb.append("no winner").append("\n");
                }
            }
            System.out.println(sb);
        }
}
