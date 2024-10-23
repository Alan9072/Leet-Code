class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] arr = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);

            }else{
                map.put(nums[i],map.get(nums[i]) + 1);
            }
        }

        int pos = 0;
        for( int key : map.keySet()){
            if(map.get(key) > 1){
                arr[pos] = key;
                pos++;
            }
        }
        return arr;
    }
}
