import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        PriorityQueue<Task> taskQueue = new PriorityQueue<>((a, b) -> a.startTime - b.startTime);
        Stack<Task> pausedTasks = new Stack<>();

        for (String[] plan : plans) {
            taskQueue.offer(new Task(plan[0], convertToMinutes(plan[1]), Integer.parseInt(plan[2])));
        }

        int currentTime = 0;
        while (!taskQueue.isEmpty() || !pausedTasks.isEmpty()) {
            if (!taskQueue.isEmpty() && (pausedTasks.isEmpty() || taskQueue.peek().startTime <= currentTime)) {
                Task currentTask = taskQueue.poll();
                currentTime = Math.max(currentTime, currentTask.startTime);
                
                if (!taskQueue.isEmpty()) {
                    int timeUntilNext = taskQueue.peek().startTime - currentTime;
                    if (currentTask.duration <= timeUntilNext) {
                        currentTime += currentTask.duration;
                        answer.add(currentTask.name);
                    } else {
                        currentTask.duration -= timeUntilNext;
                        pausedTasks.push(currentTask);
                        currentTime += timeUntilNext;
                    }
                } else {
                    currentTime += currentTask.duration;
                    answer.add(currentTask.name);
                }
            } else if (!pausedTasks.isEmpty()) {
                Task resumedTask = pausedTasks.pop();
                if (!taskQueue.isEmpty()) {
                    int timeUntilNext = taskQueue.peek().startTime - currentTime;
                    if (resumedTask.duration <= timeUntilNext) {
                        currentTime += resumedTask.duration;
                        answer.add(resumedTask.name);
                    } else {
                        resumedTask.duration -= timeUntilNext;
                        pausedTasks.push(resumedTask);
                        currentTime += timeUntilNext;
                    }
                } else {
                    currentTime += resumedTask.duration;
                    answer.add(resumedTask.name);
                }
            }
        }

        return answer.toArray(new String[0]);
    }

    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private static class Task {
        String name;
        int startTime;
        int duration;

        Task(String name, int startTime, int duration) {
            this.name = name;
            this.startTime = startTime;
            this.duration = duration;
        }
    }
}