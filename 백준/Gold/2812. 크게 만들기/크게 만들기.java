import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static String num;
    static Stack<Integer> stack;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        stack = new Stack<>();
        String answer = "";
        for (int i = 0; i < num.length(); i++) {
            check(num.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size() - K; i++) {
            sb.append(stack.get(i));
        }

        System.out.println(sb);
    }

    private static void check(char c) {
        while (K > 0 && !stack.isEmpty() && stack.peek() < (int) (c - '0')) {
            stack.pop();
            K--;
        }
        stack.add((int) (c - '0'));
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = br.readLine();
    }
}
