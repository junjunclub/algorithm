import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String A, B, C;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C)).append("\n");
        
        String sumV = A + B;
        
        sb.append(Integer.parseInt(sumV) - Integer.parseInt(C));
        System.out.println(sb);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine();
        B = br.readLine();
        C = br.readLine();
    }
}
