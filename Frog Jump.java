class Solution {
    public boolean canCross(int[] stones) {
        Map<String, Boolean> memo = new HashMap<>();
        Set<Integer> stoneSet = new HashSet<>();
        for (int s : stones)
            stoneSet.add(s);

        return dfs(0, 1, stones,stoneSet,memo);
    }

    public boolean dfs(int idx, int last, int[] stones,Set<Integer> stoneSet,Map<String, Boolean> memo) {
        if (idx == stones[stones.length - 1])
            return true;
        if ( idx > stones[stones.length - 1] || !stoneSet.contains(idx))
            return false;

        String key = idx + "," + last;
        if(memo.containsKey(key))return memo.get(key);

        if(idx == 0){
            if(stoneSet.contains(idx + 1) && dfs(idx + 1,1,stones,stoneSet,memo)){
                return true;
            }
            return false;
        }else{

            boolean low = false;
            boolean mid = false;
            boolean high = false;
            if(last - 1 > 0){
                low = dfs(idx + last - 1,last - 1,stones,stoneSet,memo);
            }

            mid = dfs(idx + last,last,stones,stoneSet,memo);

            high = dfs(idx + last + 1,last + 1,stones,stoneSet,memo);

            memo.put(key,low || mid || high);
            return memo.get(key);
        }

    }
}
