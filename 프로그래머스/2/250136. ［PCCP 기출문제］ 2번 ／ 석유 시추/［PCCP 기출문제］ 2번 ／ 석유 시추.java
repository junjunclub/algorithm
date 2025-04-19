import java.util.*;

class Solution {
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1 ,0, 0};
    static int boardR;
    static int boardC;
    static int[] answerArray;
    static boolean[][] visited;
    public int solution(int[][] land) {
        /**
        1. 전처리로 처리하면 쉬울 것 같다.
        2. 전체 배열을 한번 순회하고 석유의 크기만큼 열에 더해준다
        3. 배열 한번 순회하고 최댓값 출력
        */
        
        boardR = land.length;
        boardC = land[0].length;
        visited = new boolean[boardR][boardC];
        answerArray = new int[boardC];
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    dfs(i, j, land);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < answerArray.length; i++) {
            answer = Math.max(answer, answerArray[i]);
        }
        
        return answer;
    }
    
    private static void dfs(int r, int c, int[][] land) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        visited[r][c] = true;
        Set<Integer> set = new HashSet<>();
        set.add(c);
        
        int size = 1;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int curR = node.r;
            int curC = node.c;
            
            for (int i = 0; i < 4; i++) {
                int newR = curR + dr[i];
                int newC = curC + dc[i];
                if (0 > newR || boardR <= newR || 0 > newC || boardC <= newC || visited[newR][newC] || land[newR][newC] == 0) continue;
                
                q.add(new Node(newR, newC));
                visited[newR][newC] = true;
                set.add(newC);
                size++;
            }
        }
        
        List<Integer> lst = new ArrayList<>(set);
        
        for (int i = 0; i < lst.size(); i++) {
            int col = lst.get(i);
            answerArray[col] += size;
        }
    }
}

class Node {
    int r, c;
    public Node (int r, int c) {
        this.r = r;
        this.c = c;
    }
}