    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.Stack;

    public class Main {
        static String str;
        public static void main(String[] args) throws Exception{
                init();
                solve();
            }

        private static void solve() {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                stack.add(str.charAt(i));

                if (stack.size() >= 4) {
                    int size = stack.size();
                    if (stack.get(size - 4).equals('P') &&
                        stack.get(size - 3).equals('P') &&
                        stack.get(size - 2).equals('A') &&
                        stack.get(size - 1).equals('P')
                    ) {
                        for (int j = 0; j < 4; j++) {
                            stack.pop();
                        }
                        stack.add('P');
                    }
                }
            }
            if (stack.size() == 1 && stack.peek() == 'P') {
                System.out.println("PPAP");
            } else {
                System.out.println("NP");
            }
        }

        private static void init() throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            str = br.readLine();
        }
    }
