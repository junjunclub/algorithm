import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String bin = Integer.toBinaryString(k+1);

        for (int i = 1; i < bin.length(); i++) {
            if (bin.charAt(i) == '0') {
                sb.append('4');
            } else {
                sb.append('7');
            }
        }
        System.out.println(sb);
    }
}
