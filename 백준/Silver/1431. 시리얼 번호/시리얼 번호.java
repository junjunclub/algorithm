import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static List<Input> list;
    static class Input implements Comparable<Input>{
        String word;

        public Input (String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Input i) {
            if (this.word.length() != i.word.length()) {
                return Integer.compare(this.word.length(), i.word.length());
            }

            int tSum = getSum(this.word);
            int iSum = getSum(i.word);

            if (tSum != iSum) {
                return Integer.compare(tSum, iSum);
            }

            return this.word.compareTo(i.word);
        }
    }

    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        Collections.sort(list);

        for (Input i : list) {
            System.out.println(i.word);
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            list.add(new Input(input));
        }
    }

    private static int getSum (String s) {
        int sum = 0;
        for(int i=0; i< s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <='9') {
                sum += s.charAt(i) - '0';
            }
        }
        return sum;
    }
}
