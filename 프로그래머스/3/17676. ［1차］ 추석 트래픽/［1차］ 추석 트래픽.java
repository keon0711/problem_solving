import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Solution {

    public int solution(String[] lines) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        List<long[]> logs = new ArrayList<>();


        for (String line : lines) {
            // 2016-09-15 01:00:04.002 2.0s
            String[] split = line.split(" ");
            Date endTime = sdf.parse(split[0] + " " + split[1]);

            long processingTime = (long) (Double.parseDouble(split[2].replace("s", "")) * 1000);
            long end = endTime.getTime();
            long start = end - processingTime + 1;

            logs.add(new long[]{start, end});
        }

        int maxTraffic = 0;

        for (int i = 0; i < logs.size(); i++) {
            long[] interval = logs.get(i);
            long start = interval[1];
            long end = interval[1] + 999;
            int count = 0;

            for (int j = i; j < logs.size(); j++) {
                long[] log = logs.get(j);

                if (log[0] <= end && log[1] >= start) {
                    count++;
                }
            }
            maxTraffic = Math.max(maxTraffic, count);
        }

        return maxTraffic;
    }
}