import java.util.*;
import java.io.*;
 
public class Main {
    static int N,M,K;
    static int[][] grid, dp;
    static int ox = 0, oy = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);   // 행
        M = Integer.parseInt(str[1]);   // 열
        K = Integer.parseInt(str[2]);   // O 표시된 칸 번호
        
        grid = new int[N][M];
        
        int num = 1;
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                grid[i][j] = num++;
                
                if(grid[i][j] == K) {
                    ox = i;
                    oy = j;
                }
            }
        }
        
        // dp 2번하기
        dp = new int[N][M];
 
        // 1차) (0,0) -> (ox, oy)
        for(int i = 0 ; i <= ox ; i++) {
            for(int j = 0 ; j <= oy ; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        
        // 2차) (ox, oy) -> (n-1, m-1)
        for(int i = ox ; i < N ; i++) {
            for(int j = oy ; j < M ; j++) {
                if(i == ox || j == oy)
                    dp[i][j] = dp[ox][oy];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        System.out.println(dp[N-1][M-1]);
    }
}