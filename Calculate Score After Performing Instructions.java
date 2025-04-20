class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long sum = 0;
        int i = 0;
        Set<Integer> visited = new HashSet<>();

        while (i >= 0 && i < instructions.length && !visited.contains(i)) {
            visited.add(i);
            if (instructions[i].equals("jump")) {
                i += values[i];
            } else {
                sum += values[i];
                i++;
            }
        }

        return sum;
    }
}
