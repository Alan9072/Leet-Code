import java.util.*;

class Solution {
    List<String> result = new ArrayList<>();
    int[] hrs = {1, 2, 4, 8};
    int[] mins = {1, 2, 4, 8, 16, 32};
    Set<String> seen = new HashSet<>();
    Set<String> visited = new HashSet<>();

    public List<String> readBinaryWatch(int turnedOn) {
        dfs(0, 0, 0, 0, turnedOn);
        return result;
    }

    void dfs(int i, int j, int hours, int minutes, int num) {
        if (hours > 11 || minutes > 59) return;
        int remaining = (hrs.length - i) + (mins.length - j);
        if (num > remaining) return;

        String state = i + "|" + j + "|" + hours + "|" + minutes + "|" + num;
        if (!visited.add(state)) return;

        if (num == 0) {
            String time = hours + ":" + (minutes < 10 ? "0" : "") + minutes;
            if (seen.add(time)) result.add(time);
            return;
        }

        if (i < hrs.length) dfs(i + 1, j, hours + hrs[i], minutes, num - 1);
        if (i < hrs.length) dfs(i + 1, j, hours, minutes, num);

        if (j < mins.length) dfs(i, j + 1, hours, minutes + mins[j], num - 1);
        if (j < mins.length) dfs(i, j + 1, hours, minutes, num);
    }
}
