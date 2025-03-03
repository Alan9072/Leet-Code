class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int equal = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < pivot){
                list1.add(nums[i]);
            }else if(nums[i] > pivot){
                list2.add(nums[i]);
            }else{
                equal++;
            }
        }
        int[] result = new int[nums.length];
        int index = 0;
        for(int val:list1){
            result[index] = val;
            index++;
        }
        for(int i=0;i<equal;i++){
            result[index] = pivot;
            index++;
        }
        for(int val:list2){
            result[index] = val;
            index++;
        }
        return result;

    }
}
