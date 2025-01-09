import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        /**
         * 2의 n승이 k보다 작을 때가 e
         * s는 0부터 (k가 1이면 0임)
         */
        int choco = 0;
        for (int i = 0; i < k; i++) {
            choco = 1 << i;
            if (choco >= k) {
                sb.append(choco).append(" ");
                break;
            }
        }
        int sumV = 0;
        int cnt = 0;
        while (true) {
            if ((choco + sumV) <= k) {
                sumV += choco;
            }
            if (sumV == k) {
                break;
            }
            cnt++;
            choco /= 2;
        }
        sb.append(cnt);
        System.out.println(sb);
    }
}
