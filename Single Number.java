class Solution {
    public int singleNumber(int[] nums) {
        int rslt = 0;
        for(int i=0;i<nums.length;i++){
            rslt = rslt ^ nums[i];
        }
        return rslt;
    }
}

// class Solution {
//     public int singleNumber(int[] nums) 
//     {
//         int element=0;
//         int flag;
//         for(int i=0;i<nums.length;i++)
//             {   flag=0;
//                 element = nums[i];
//                 for(int j=0;j<nums.length;j++)
//                     {
//                         if(nums[j]==element)
//                         {
//                             flag++;
//                         }
//                     }
//                 if(flag == 1)
//                 {
//                     return element;
//                 }
//             }
//         return element;
//     }
    
// }
