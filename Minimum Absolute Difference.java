class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        int mindiff = Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            mindiff = Math.min(mindiff,arr[i] - arr[i-1]);
        }

        for(int i=1;i<arr.length;i++){
            if(arr[i] - arr[i-1] == mindiff){
                List<Integer> sub = new ArrayList<>();
                sub.add(arr[i-1]);
                sub.add(arr[i]);

                result.add(sub);
            }
        }
        return result;

    }
}
