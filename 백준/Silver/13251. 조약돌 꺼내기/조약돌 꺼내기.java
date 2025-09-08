import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        int N = 0;
        int[] color = new int[M];
        for(int i=0; i<M; i++){
            color[i] = Integer.parseInt(st.nextToken());
            N += color[i];
        }

        int K = Integer.parseInt(br.readLine());
        double answer = 0;
        for(int i=0; i<M; i++){
            double value = 1;
            for(int j=0; j<K; j++){
                value *= ((double) (color[i]-j) / (N-j));
            }
            answer += value;
        }
        System.out.println(answer);

    }
}