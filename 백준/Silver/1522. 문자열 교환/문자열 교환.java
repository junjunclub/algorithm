import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int aCnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a') {
                aCnt++;
            }
        }
        int minV = Integer.MAX_VALUE;
        for (int j = 0; j < word.length(); j++) {
            int bCnt = 0;
            for (int k = j; k < j + aCnt; k++) {
                if (word.charAt(k % word.length()) == 'b') {
                    bCnt++;
                }
            }
            minV = Math.min(minV, bCnt);
        }
        System.out.println(minV);
    }
}
