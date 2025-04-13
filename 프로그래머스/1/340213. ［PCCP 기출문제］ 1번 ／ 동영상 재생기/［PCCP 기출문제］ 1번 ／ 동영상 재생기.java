import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        // 오프닝 시작과 끝 사이일 경우 오프닝 끝나는 시점으로 이동,
        
        int nowTime = toSeconds(pos);
        int opStartTime = toSeconds(op_start);
        int opEndTime = toSeconds(op_end);
        int totalTime = toSeconds(video_len);
        
        if (nowTime >= opStartTime && nowTime < opEndTime) {
            nowTime = opEndTime;
        }     
        // commands를 순회하면서 앞 뒤 10초씩 이동. 범위 생각하고, 분 -> 시간 넘겨주기
        
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("next")) {
                if (nowTime + 10 > totalTime) {
                    nowTime = totalTime;
                } else {
                    nowTime += 10;
                }
            } else {
                if (nowTime - 10 < 0) {
                    nowTime = 0;
                } else {
                    nowTime -= 10;
                }
            }
            if (nowTime >= opStartTime && nowTime < opEndTime) {
                nowTime = opEndTime;
            }
        }
        
        String answerHour = String.format("%02d", nowTime / 60);
        String answerMinute = String.format("%02d",nowTime % 60);
        
        return answerHour + ":" + answerMinute;
    }
    
    private int toSeconds(String time) {
    String[] parts = time.split(":");
    int h = Integer.parseInt(parts[0]);
    int m = Integer.parseInt(parts[1]);
    return h * 60 + m;
    }   
}