import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String balls = br.readLine();

        char lastColor;

        lastColor = balls.charAt(n-1);

        int lCCnt = 0;
        int nLCCnt = 0;

        boolean flag = false;

        for (int i = n-1; i >= 0; i--) {
            if (balls.charAt(i) == lastColor && flag) {
                lCCnt++;
            } else if (balls.charAt(i) != lastColor) {
                nLCCnt++;
                flag = true;
            }
        }

        System.out.println(Math.min(lCCnt, nLCCnt));
    }
}
