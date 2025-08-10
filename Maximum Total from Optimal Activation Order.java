class Solution {
    public long maxTotal(int[] value, int[] limit) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < value.length; i++) {
            int arr[] = new int[2];
            arr[0] = limit[i];
            arr[1] = value[i];
            list.add(arr);
        }
        int[] activeness = new int[100001];

        Collections.sort(list, (a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        Set<Integer> set = new HashSet<>();
        for(int val : limit){
            set.add(val);
        }
        
        int active = 0;
        long sum = 0;
        for(int[] arr : list){
            int lim = arr[0];
            if(set.contains(lim)){
                active++;
                activeness[lim]++;
                sum += arr[1];

                if(set.contains(active)){
                    set.remove(active);
                    active -= activeness[active];
                }
            }
        }
        return sum;


    }
}
