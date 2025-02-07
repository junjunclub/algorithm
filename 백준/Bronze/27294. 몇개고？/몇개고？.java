import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int T = Integer.parseInt(s[0]); // 시간
        int S = Integer.parseInt(s[1]); // 술의 유무

        // 술하고 같이 초밥을 먹거나 점심 식사가 아닐 때는 초밥의 밥알 = 280개
        if ((T >= 12 && T < 17) && S == 0)
            System.out.println(320);
        else
            System.out.println(280);
    }
}