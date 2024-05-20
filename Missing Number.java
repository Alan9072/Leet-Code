class Solution {
    public int missingNumber(int[] nums) {

        int flag;
        int length = nums.length;
        for(int i=0;i<=length;i++)
            {
            flag=0;
            for(int j=0;j<length;j++)
                {
                if(nums[j]==i)
                    {
                    flag=1;
                    break;
                    }
               
            }
            if(flag==0)
                return i;
        }
        
      return -1;  
    }
}