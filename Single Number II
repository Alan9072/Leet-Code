class Solution {
    int number;
    public int singleNumber(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {  
            int flag = 0;
            number=nums[i];
            for(int j=0;j<nums.length;j++)
            {
                if(i == j)continue;
                if(nums[j] == number)
                {
                    flag++;
                }
            }
            if(flag == 0)break;
            
        }
       
    return number;
    }
}
