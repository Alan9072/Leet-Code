class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] abc = new int[n];
        int[] bcd = new int[n];
        int j = 0;
        for(int i=0;i<nums.length;i++)
        {   
            if(i<n)
            {
                abc[i]=nums[i];
            }
            else
            {
                bcd[j]=nums[i];
                j++;
            }
            
        }
        int a = 0;
        int b = 0;
         for(int i=0;i<nums.length;i++)
         {
             if(i%2 == 0)
             {
                nums[i]=abc[b];
                 b++; 
             }  
             else
             {
               nums[i]=bcd[a];
               a++;  
             }
         }
    return nums;
    }
}
