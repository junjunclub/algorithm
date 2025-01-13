import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        int num = 1;

        while(n > 0){
            if(n < num){
                num=1;
            }else{
                n = n - num;
                num += 1;
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}
