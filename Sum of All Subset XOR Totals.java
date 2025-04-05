class Solution {
    int sum = 0;
    public int subsetXORSum(int[] nums) {
       
        find(nums,0,new ArrayList<>());
        return sum;
        
    }
    public void find(int[] nums,int index,List<Integer> sub){
        if(index == nums.length){
            int subSum = 0;
            for(int val:sub){
                subSum ^= val;
            }
            sum += subSum;
            return;
        }

        for(int i=index;i<nums.length;i++){

            sub.add(nums[i]);
            find(nums,i+1,sub);
            sub.remove(sub.size() - 1);

        }

        int subSum = 0;
            for(int val:sub){
                subSum ^= val;
            }
            sum += subSum;
            return;

    }
}
