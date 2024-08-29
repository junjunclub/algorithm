import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int cnt = 0;
        if (A < 5 && A % 2 != 0) {
            System.out.println(-1);
        } else {
            while (A % 5 != 0) {
                A -= 2;
                cnt += 1;
            }
            cnt += (A / 5);
            System.out.println(cnt);
        }
    }
}
