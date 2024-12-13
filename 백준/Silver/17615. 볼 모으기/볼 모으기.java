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

        char firstColor;

        firstColor = balls.charAt(0);

        int fCCnt = 0;
        int nFCCnt = 0;

        flag = false;

        for (int i = 0; i < n; i++) {
            if (balls.charAt(i) == firstColor && flag) {
                fCCnt++;
            } else if (balls.charAt(i) != firstColor) {
                nFCCnt++;
                flag = true;
            }
        }
        int minFC = Math.min(fCCnt, nFCCnt);
        int minLC = Math.min(lCCnt, nLCCnt);
        System.out.println(Math.min(minFC, minLC));
    }
}
