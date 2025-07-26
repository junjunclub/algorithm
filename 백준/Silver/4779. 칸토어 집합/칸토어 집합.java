import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
            init();
        }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);

            StringBuilder sb = new StringBuilder();

            int newLength = (int) Math.pow(3, n);

            arr = new char[newLength];

            Arrays.fill(arr, '-');

            divide(0, newLength);

            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            System.out.println(sb);
        }
    }

    private static void divide(int start, int length) {
        if (length <= 1) {
            return;
        }

        int newLength = length / 3;

        for (int i = start + newLength; i < start + newLength * 2; i++) {
            arr[i] = ' ';
        }

        divide(start, newLength);
        divide(start + newLength * 2, newLength);
     }
}
