import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            dfs(1, 1, 0, 1, "1");
            System.out.println(sb);
        }
    }

    private static void dfs(int idx, int num, int sum, int op, String str) {
        if (idx == n) {
            sum += (num*op);
            if (sum == 0) {
                sb.append(str+"\n");
            }
            return;
        }
        dfs(idx+1, num*10+(idx+1), sum, op, str+" "+Integer.toString(idx+1));
        dfs(idx+1, idx+1, sum+(num*op), 1, str+"+"+Integer.toString(idx+1));
        dfs(idx+1, idx+1, sum+(num*op), -1, str+"-"+Integer.toString(idx+1));
    }
}
