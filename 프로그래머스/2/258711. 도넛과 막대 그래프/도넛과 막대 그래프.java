import java.util.*;
class Solution {
    static int[] visited;
    static List<Integer>[] nodes;
    static int[] answer;
    public int[] solution(int[][] edges) {
        answer = new int[4];
        
        int N = edges.length;
        
        int nodeCnt = 0;
        
        for (int i = 0; i < edges.length; i++) {
            int out = edges[i][0];
            int in = edges[i][1];

            nodeCnt = Math.max(nodeCnt, out);
            nodeCnt = Math.max(nodeCnt, in);
        }
        
        int start = 0;
        int[][] list = new int[nodeCnt+1][2];
        
        for (int i = 0; i < edges.length; i++) {
            int out = edges[i][0];
            int in = edges[i][1];
            
            list[out][0]++;
            list[in][1]++;
        }
        
        nodes = new ArrayList[nodeCnt+1];
        
        for (int i = 0; i <= nodeCnt; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            int out = edges[i][0];
            int in = edges[i][1];
            
            nodes[out].add(in);
        }
        
        visited = new int[nodeCnt+1];
        
        for (int i = 1; i <= nodeCnt; i++) {
            if (list[i][0] >= 2 && list[i][1] == 0) {
                answer[0] = i;
            }
            
            if (list[i][0] >= 2 && list[i][1] >= 2) {
                answer[3]++;
            }
            
            if (list[i][0] == 0 && list[i][1] >= 1) {
                answer[2]++;
            }
        }
        
//         for (int i = 0; i < list.length; i++) {
//             System.out.print(list[i][0]);
//             System.out.print(" ");
//             System.out.print(list[i][1]);
//             System.out.println();
//         }
        
        int donut = nodes[answer[0]].size() - answer[2] - answer[3];
        answer[1] = donut;
        
        return answer;
    }
}