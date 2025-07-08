class Solution {
    Set<Integer> set = new HashSet<>();

    public int mincostTickets(int[] days, int[] costs) {
        int last = days[days.length - 1];
        int[] dp = new int[last + 1];
        Arrays.fill(dp, -1);

        for (int val : days) {
            set.add(val);
        }

        return dfs(days, costs, dp, 1);
    }

    public int dfs(int[] days, int[] costs, int[] dp, int currDay) {
        if (currDay > days[days.length - 1])
            return 0;
            
        if (dp[currDay] != -1)
            return dp[currDay];

        

        if (set.contains(currDay)) {

            int oneDay = costs[0] + dfs(days, costs, dp, currDay + 1);

            int sevenDay = costs[1] + dfs(days, costs, dp, currDay + 7);

            int month = costs[2] + dfs(days, costs, dp, currDay + 30);

            return dp[currDay] = Math.min(oneDay, Math.min(sevenDay, month));
        }else{
            return dfs(days,costs,dp,currDay + 1);
        }

    }
}
