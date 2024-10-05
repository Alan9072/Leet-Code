class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums1.length;i++){
            stack.push(nums1[i]);
            int pos = 0;
            for(int j=0;j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    pos = j;
                    break;
                }
            }
            int start = pos;
            while(start <= nums2.length - 1 && nums2[start] <= stack.peek()){
                start++;
            }
            if(start == nums2.length){
                result[i] = -1;
            }
            else{
                result[i] = nums2[start];
            }
        }
        return result;
    }
}
