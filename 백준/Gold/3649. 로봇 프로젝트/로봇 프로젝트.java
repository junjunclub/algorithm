import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
            init();
        }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            int size = Integer.parseInt(input)*10000000;

            int N = Integer.parseInt(br.readLine());
            int[] list = new int[N];

            for (int i = 0; i < N; i++) {
                list[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(list);

            int left = 0;
            int right = N - 1;
            boolean flag = false;

            while (left < right) {
                int sum = list[left] + list[right];

                if (sum == size) {
                    sb.append("yes").append(" ").append(list[left]).append(" ").append(list[right]).append("\n");
                    flag = true;
                    break;
                } else if (sum > size) {
                    right--;
                } else {
                    left++;
                }
            }

            if (!flag) {
                sb.append("danger").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
