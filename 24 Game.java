class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int val : cards) {
            list.add((double) val);
        }
        return dfs(list);
    }

    public boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            // Use epsilon instead of Math.round
            return Math.abs(list.get(0) - 24.0) < 1e-6;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;

                double a = list.get(i);
                double b = list.get(j);

                int first = Math.max(i, j);
                int second = Math.min(i, j);

                list.remove(first);
                list.remove(second);

                // + addition
                double sum = a + b;
                list.add(sum);
                if (dfs(list)) return true;
                list.remove(list.size() - 1);

                // - subtraction
                sum = a - b;
                list.add(sum);
                if (dfs(list)) return true;
                list.remove(list.size() - 1);

                // * multiplication
                sum = a * b;
                list.add(sum);
                if (dfs(list)) return true;
                list.remove(list.size() - 1);

                // / division
                if (b != 0) {
                    sum = a / b;
                    list.add(sum);
                    if (dfs(list)) return true;
                    list.remove(list.size() - 1);
                }

                // restore list
                if (i < j) {
                    list.add(i, a);
                    list.add(j, b);
                } else {
                    list.add(j, b);
                    list.add(i, a);
                }
            }
        }
        return false;
    }
}
