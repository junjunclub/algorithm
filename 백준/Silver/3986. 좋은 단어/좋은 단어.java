import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (check(str)) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean check(String str) {
        int size = str.length();

        if (size % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            char c = str.charAt(i);

            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
                continue;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}
