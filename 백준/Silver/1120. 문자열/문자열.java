import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        int minV = 100;
        for (int i = 0; i < B.length()-A.length()+1; i++) {
            int temp = 0;
            for (int j = 0; j < A.length(); j++) {
                char a  = A.charAt(j);
                char b = B.charAt(i+j);
                if (a != b) {
                    temp++;
                    if (temp > minV) {
                        break;
                    }
                }
            } if (temp < minV) {
                minV = temp;
            }
        }
        System.out.println(minV);
    }
}
