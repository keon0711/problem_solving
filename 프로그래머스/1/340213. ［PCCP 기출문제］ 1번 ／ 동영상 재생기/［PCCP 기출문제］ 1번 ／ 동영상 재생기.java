class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int videoLenSeconds = toSeconds(video_len);
        int posSeconds = toSeconds(pos);
        int opStartSeconds = toSeconds(op_start);
        int opEndSeconds = toSeconds(op_end);

        for (String command : commands) {
            if (posSeconds >= opStartSeconds && posSeconds <= opEndSeconds) {
                posSeconds = opEndSeconds;
            }

            if (command.equals("next")) {
                posSeconds = posSeconds > videoLenSeconds - 10 ? videoLenSeconds : posSeconds + 10;
            } else if (command.equals("prev")) {
                posSeconds = posSeconds < 10 ? 0 : posSeconds - 10;
            }
            
        }

        if (posSeconds >= opStartSeconds && posSeconds <= opEndSeconds) {
            posSeconds = opEndSeconds;
        }
        return toTime(posSeconds);
    }

    private String toTime(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    private int toSeconds(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}