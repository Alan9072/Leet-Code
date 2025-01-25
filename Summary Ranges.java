class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int[] arr = new int[2];
            arr[0] = nums[i];
            arr[1] = nums[i];

            int curr = nums[i];
            for(int j = i+1;j<nums.length;j++){
                if(curr + 1 != nums[j]){
                    break;
                }
                i++;
                curr = nums[j];
                arr[1] = curr;

            }
            if(arr[0] == arr[1]){
                result.add(""+arr[1]);
            }else{
                result.add(arr[0]+"->"+arr[1]);
            }
            
        }
        return result;
    }
}
