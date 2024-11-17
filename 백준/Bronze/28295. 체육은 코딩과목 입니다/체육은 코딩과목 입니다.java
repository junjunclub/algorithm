import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer= 0;
        for (int i = 0; i < 10; i++) {
            int temp = Integer.parseInt(br.readLine());
            answer += temp;
        }
        answer %= 4;

        switch (answer) {
            case 0:
                System.out.println("N");
                break;
            case 1:
                System.out.println("E");
                break;
            case 2:
                System.out.println("S");
                break;
            case 3:
                System.out.println("W");
                break;
        }
    }
}
