import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] sList = new String[s.length()];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sList[i] = s.substring(i);
        }

        Arrays.sort(sList);

        for (int i = 0; i < s.length(); i++) {
            sb.append(sList[i]).append("\n");
        }

        System.out.println(sb);
    }
}
