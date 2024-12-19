import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int r = n+1;
        int c = m+1;

        int rCnt = 0;
        int cCnt = 0;

        while (h >= 1) {
            h -= r;
            rCnt++;
        }

        while (w >= 1) {
            w -= c;
            cCnt++;
        }

        System.out.println(rCnt * cCnt);
    }
}
