import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        int[] alpha = new int[26];

        for (int i = 0; i < name.length(); i++) {
            int idx = name.charAt(i)-'A';
            alpha[idx]++;
        }

        int one = 0;

        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 == 1) {
                one++;
            }
        }
        String answer = "";
        if (one > 1) {
            answer += "I'm Sorry Hansoo";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < alpha.length; i++) {
                for (int j = 0; j < alpha[i] / 2; j++) {
                    sb.append((char) (i+65));
                }
            }
            answer += sb.toString();
            String end = sb.reverse().toString();
            sb = new StringBuilder();
            for (int i = 0; i < alpha.length; i++) {
                if (alpha[i] % 2 == 1) {
                    sb.append((char) (i+65));
                }
            }
            answer += sb.toString()+end;
        }
        System.out.println(answer);

    }
}
